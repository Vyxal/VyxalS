package vyxal

import collection.mutable.ListBuffer

class SyntaxError(msg: String, row: Int, col: Int)
    extends RuntimeException(s"Syntax error: $msg at $row:$col")

class Parser(private val prog: Iterator[Char]) {
  private var row, col = 0
  private var lastChar = '\u0000'
  private val buf = ListBuffer.empty[Char]

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
    this.lastChar = char
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

  /** Parse a single AST. Expects the program to have been trimmed beforehand
    */
  private def parseAST(): AST = {
    assert(this.nonEmpty)

    val char = next()
    assert(!isStructureCloser(char))
    assert(!char.isWhitespace)
    assert(char != '#')

    char match {
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
      case '[' => parseIf()
      case '(' => parseFor()
      case '{' => parseWhile()
      case '.' =>
        Literal(if (isEmpty) VNum(1, 2) else afterDecimal())
      case d if d.isDigit =>
        var num = BigInt(d - '0')
        while (nonEmpty && this.peek.isDigit) {
          num = num * 10 + (next() - '0')
        }
        Literal(
          if (nonEmpty && this.peek == '.') VNum(num, 1) + afterDecimal()
          else VNum(num, 1)
        )
      case c =>
        parseModifierOrElem(s"$c")
    }
  }

  /** Get the part of a number after the decimal as a `VNum`
    */
  private def afterDecimal(): VNum = {
    var num = BigInt(0)
    var den = BigInt(1)
    while (nonEmpty && this.peek.isDigit) {
      num = num * 10 + (next() - '0')
      den *= 10
    }
    VNum(num, den)
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

  private def parseIf(): AST =
    parseCtrlStruct(']'){ (truthy, falsey) =>
      If(truthy, falsey.getOrElse(Cmds.empty))
    }

  private def parseFor(): AST =
    parseCtrlStruct(')') {
      case (varName, Some(body)) =>
        val nameStr = varName match {
          case Element(name) => name
          case Cmds(cmds*) =>
            cmds.collect { case Element(name) => name }.mkString("")
          case _ => ""
        }
        val alphaName = nameStr.filter(c =>
          'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || c == '_'
        )
        For(Some(alphaName), body)
      case (body, None) =>
        For(None, body)
    }

  private def parseWhile(): AST =
    parseCtrlStruct(')') {
      case (cond, Some(body)) => While(Some(cond), body)
      case (body, None) => While(None, body)
    }

  private def parseModifierOrElem(sym: String): AST = {
    if (Builtins.monadicModifiers.contains(sym)) {
      Builtins.monadicModifiers(sym)(
        parseASTOrEmpty()
      )
    } else if (Builtins.dyadicModifiers.contains(sym)) {
      Builtins.dyadicModifiers(sym)(
        parseASTOrEmpty(),
        parseASTOrEmpty()
      )
    } else if (Builtins.triadicModifiers.contains(sym)) {
      Builtins.triadicModifiers(sym)(
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
    val elems = ListBuffer.empty[AST]
    this.trim()
    while (this.nonEmpty && !isStructureCloser(this.peek)) {
      elems += parseAST()
      this.trim()
    }
    elems.toList
  }

  /** Parse multiple elements as if they're one AST
    */
  def parseElemGroup(): AST = parseElems() match {
    case List(elem) => elem
    case elems => Cmds(elems*)
  }
}

object Parser {
  def parse(prog: Iterator[Char]): AST = Parser(prog).parseElemGroup()

  def parse(str: String): AST = Parser.parse(str.iterator)
}
