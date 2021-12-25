package vyxal

import collection.mutable.ListBuffer

class Parser(private val prog: Iterator[Char]) {
  private var row, col = 0
  private var lastChar = '\u0000'

  private def next() = {
    val char = prog.next
    this.lastChar = char
    if (char == '\n') {
      this.row += 1
      this.col = 0
    } else {
      this.col += 1
    }
    char
  }

  /**
   * Whether or not this character closes a structure
   */
  private def isStructureDelimiter(char: Char) =
    char == ';' || char == ']' || char == ')' || char == '}' || char == '|'

  /** Parse a single AST. Returns null if it could not parse a tree. This
    * happens if there's whitespace, there's a comment, the close of a structure
    * was reached, or the program's end has been reached.
    */
  private def parseAST(): AST | Null = {
    if (!prog.hasNext) return null

    val char = next()
    if (isStructureDelimiter(char) || char.isWhitespace) return null
    char match {
      case '#' =>
        while (prog.hasNext && next() != '\n') {}
        parseAST()
      case 'λ' | 'ƛ' | '\'' | 'µ' =>
        val body = parseElems()
        val kind = char match {
          case 'λ'  => LambdaKind.Normal
          case 'ƛ'  => LambdaKind.Map
          case '\'' => LambdaKind.Filter
          case 'µ'  => LambdaKind.Sort
        }
        Lambda(body, kind)
      case '[' => parseIf()
      case '(' => parseFor()
      case '{' => parseWhile()
      case c => Element("" + c)
    }
  }

  private def parseIf() = {
    val truthy = parseElems()
    this.lastChar match {
      case '|' =>
        val falsey = parseElems()
        If(truthy, falsey)
      case _ =>
        // No falsey branch
        If(truthy, List.empty)
    }
  }

  private def parseFor() = {
    val varNameOrBody = parseElems()
    println("lastchar=" + this.lastChar + ", varname=" + varNameOrBody)
    this.lastChar match {
      case '|' =>
        // It's got a variable name
        val body = parseElems()
        val name = varNameOrBody
          .collect { case Element(name) =>
            name.filter(c =>
              'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || c == '_'
            )
          }
          .mkString("")
        For(Some(name), body)
      case _ =>
        // It's only the loop body
        For(None, varNameOrBody)
    }
  }

  private def parseWhile() = {
    val condOrBody = parseElems()
    this.lastChar match {
      case '|' =>
        val body = parseElems()
        While(Some(condOrBody), body)
      case _ =>
        // Infinite loop
        While(None, condOrBody)
    }
  }

  /** Parse a bunch of elements and return those elements as well as the last
    * character parsed.
    */
  private def parseElems(): List[AST] = {
    val elems = ListBuffer.empty[AST]
    while (prog.hasNext) {
      val ast = parseAST()
      if (ast != null) elems += ast
      else if (isStructureDelimiter(this.lastChar)) return elems.toList
    }
    elems.toList
  }

  /** Parse the entire thing
    */
  def parseComplete(): AST = Commands(parseElems())

}

object Parser {
  def parse(prog: Iterator[Char]): AST = Parser(prog).parseComplete()

  def parse(str: String): AST = Parser.parse(str.iterator)
}

class SyntaxError(message: String, pos: (Int, Int)) extends Exception(message)
