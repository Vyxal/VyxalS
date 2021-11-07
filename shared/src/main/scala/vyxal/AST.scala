package vyxal

/** An AST representing Vyxal code
  */
sealed trait AST

case class Element(symbol: String) extends AST

/** Basically a line of Vyxal code
  */
case class Commands(cmds: List[AST]) extends AST
