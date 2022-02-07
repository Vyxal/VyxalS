package vyxal

import collection.{mutable => mut}

class SyntaxError(msg: String, row: Int, col: Int)
    extends RuntimeException(s"Syntax error: $msg at $row:$col")

/** A position in a file */
case class Pos(row: Int, col: Int)

class Parser(private val prog: Iterator[Char]) {
  private var row, col = 0
  private val buf = mut.ListBuffer.empty[Char]

  /** Record AST positions for debugging later */
  private val astPositions = mut.Map.empty[AST, Pos]

  /** Do we have any more characters to consume?
    */
  private def nonEmpty = buf.nonEmpty || prog.nonEmpty
  private def isEmpty = !nonEmpty

  private def peek = {
    if (buf.isEmpty) {
      val char = prog.next
      buf += char
    }
    buf.head
  }

  private def next() = {
    val char = if (buf.isEmpty) prog.next else buf.remove(0)
    if (char == '\n') {
      this.row += 1
      this.col = 0
    } else {
      this.col += 1
    }
    char
  }

  /** Skip over whitespace and comments
    */
  private def trim() = {
    while (this.nonEmpty && this.peek.isWhitespace) {
      if (next() == '#') {
        while (this.nonEmpty && this.peek != '\n') {
          next()
        }
      }
    }
  }

  /** Whether or not this character closes a structure
    */
  private def isStructureCloser(char: Char) =
    char == ';' || char == ']' || char == ')' || char == '}' || char == '|'

  private def isAlpha(char: Char) =
    'a' <= char && char <= 'z' || 'A' <= char && char <= 'Z'

  /** Parse a single AST. Expects the program to have been trimmed beforehand
    */
  private def parseAST(): AST = {
    assert(this.nonEmpty)

    val char = next()
    assert(!isStructureCloser(char))
    assert(!char.isWhitespace)
    assert(char != '#')

    val ast = char match {
      case 'λ' | 'ƛ' | '\'' | 'µ' =>
        val body = parseElemGroup()
        val lam = Lambda(body, LambdaKind.Normal)
        if (char == 'λ') {
          lam
        } else {
          val elem = char match {
            case 'ƛ' => "M"
            case '\'' => "F"
            case 'µ' => "ṡ"
          }
          LambdaWithOp(lam, Element(elem))
        }
      case '†' => ExecFn()
      case '[' =>
        parseCtrlStruct(']') { (truthy, falsey) =>
          If(truthy, falsey.getOrElse(Cmds.empty))
        }
      case '{' =>
        parseCtrlStruct(')') {
          case (cond, Some(body)) => While(Some(cond), body)
          case (body, None) => While(None, body)
        }
      case '(' =>
        parseCtrlStruct(')') {
          case (varName, Some(body)) =>
            val nameStr = varName match {
              case Element(name) => name
              case Cmds(cmds*) =>
                cmds.collect { case Element(name) => name }.mkString("")
              case _ => ""
            }
            val alphaName = nameStr.filter(c => isAlpha(c) || c == '_')
            For(Some(alphaName), body)
          case (body, None) =>
            For(None, body)
        }
      case '←' => VarGet(parseIdent())
      case '→' => VarSet(parseIdent())
      case '@' =>
        parseFn()
      case '.' =>
        Literal(if (this.isEmpty) VNum(1, 2) else afterDecimal(0))
      case d if d.isDigit =>
        var num = BigInt(d - '0')
        while (nonEmpty && this.peek.isDigit) {
          num = num * 10 + (this.next() - '0')
        }
        Literal(
          if (nonEmpty && this.peek == '.') {
            this.next()
            afterDecimal(num)
          } else {
            VNum(num, 1)
          }
        )
      case c => parseModifierOrElem(s"$c")
    }
    // Record the position of this AST
    astPositions(ast) = Pos(this.row, this.col)
    ast
  }

  /** Get the part of a number after the decimal as a `VNum`
    * @param beforeDecimal
    *   The stuff before the decimal. Gets added to the stuff after the decimal
    */
  private def afterDecimal(beforeDecimal: BigInt): VNum = {
    var num = beforeDecimal
    var den = BigInt(1)
    while (nonEmpty && this.peek.isDigit) {
      num = num * 10 + (next() - '0')
      den *= 10
    }
    VNum(num, den)
  }

  private def parseIdent(): String = {
    val id = StringBuilder()
    while (this.nonEmpty && isAlpha(this.peek)) id += this.next()
    id.toString
  }

  /** Parse if, for, while. Assumes the first character of the structure is
    * already consumed
    * @param close
    *   The closing character of the structure
    * @param f
    *   A function to apply to the parts of the structure
    * @return
    *   The first part of the structure and the second part, if it exists
    */
  private def parseCtrlStruct(
      close: Char
  )(f: (AST, Option[AST]) => AST): AST = {
    val first = parseElemGroup()
    if (this.isEmpty) {
      f(first, None)
    } else if (this.peek == '|') {
      this.next()
      val second = parseElemGroup()
      if (this.nonEmpty && this.peek == close) this.next()
      f(first, Some(second))
    } else if (this.peek == close) {
      this.next()
      f(first, None)
    } else {
      // Some other structure closed here, so autoclose the current one
      f(first, None)
    }
  }

  private def parseFn(): AST = {
    this.trim()
    val name = StringBuilder()
    while (this.nonEmpty && this.peek != ':' && this.peek != '|') {
      name += this.next()
    }
    if (this.isEmpty) {
      FnDef(name.toString, List.empty, Cmds.empty)
    } else {
      val arityOrParams = if (this.next() == '|') {
        List.empty
      } else {
        var params = mut.ListBuffer[Int | String]()
        while (this.nonEmpty && this.peek != '|') {
          val param = StringBuilder()
          var allDigits = true
          while (this.nonEmpty && this.peek != ':') {
            val c = this.next()
            param += c
            if (c.isDigit) {
              allDigits = false
            }
          }
          if (this.nonEmpty) this.next()
          if (allDigits) {
            params += param.toString.toInt
          } else {
            params += param.toString
          }
        }
        if (this.nonEmpty) this.next()
        params.toList
      }
      val body = parseElemGroup()
      if (this.nonEmpty && this.peek == ';') this.next()
      FnDef(name.toString, arityOrParams, body)
    }
  }

  private def parseModifierOrElem(sym: String): AST = {
    if (Modifiers.monadicModifiers.contains(sym)) {
      Modifiers.monadicModifiers(sym)(
        parseASTOrEmpty()
      )
    } else if (Modifiers.dyadicModifiers.contains(sym)) {
      Modifiers.dyadicModifiers(sym)(
        parseASTOrEmpty(),
        parseASTOrEmpty()
      )
    } else if (Modifiers.triadicModifiers.contains(sym)) {
      Modifiers.triadicModifiers(sym)(
        parseASTOrEmpty(),
        parseASTOrEmpty(),
        parseASTOrEmpty()
      )
    } else {
      Element(sym)
    }
  }

  private def parseASTOrEmpty(): AST = {
    this.trim()
    if (this.nonEmpty) parseAST()
    else Cmds.empty
  }

  /** Parse a bunch of elements up to a structure closer and return those
    * elements as well as the last character parsed.
    */
  private def parseElems(): List[AST] = {
    val elems = mut.ListBuffer.empty[AST]
    this.trim()
    while (this.nonEmpty && !isStructureCloser(this.peek)) {
      elems += parseAST()
      this.trim()
    }
    elems.toList
  }

  /** Parse multiple elements as if they're one AST
    */
  private def parseElemGroup(): AST = parseElems() match {
    case List(elem) => elem
    case elems => Cmds(elems*)
  }
}

object Parser {
  def parse(prog: Iterator[Char]): VyFile = {
    val parser = Parser(prog)
    val ast = parser.parseElemGroup()
    assert(parser.isEmpty, s"Only parsed ${ast}, but not empty")
    VyFile(ast, parser.astPositions.toMap)
  }

  def parse(str: String): VyFile = Parser.parse(str.iterator)
}
