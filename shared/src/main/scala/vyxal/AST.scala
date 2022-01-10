package vyxal

/** An AST representing Vyxal code
  */
sealed trait AST

case class Literal(value: VAny) extends AST

case class Element(symbol: String) extends AST

/** Basically a line of Vyxal code
  */
case class Commands(cmds: List[AST]) extends AST

/** Represents variable access (←varName)
  */
case class VarGet(name: String) extends AST

/** Represents variable assignment (→varName)
  */
case class VarSet(name: String) extends AST

case class If(truthy: List[AST], falsey: List[AST]) extends AST

case class For(loopVar: Option[String], body: List[AST]) extends AST

case class While(cond: Option[List[AST]], body: List[AST]) extends AST

case class FnDef(params: Option[List[String]], body: List[AST]) extends AST

case class FnRef(name: String) extends AST

case class MonadicModifier(name: String, elem1: AST) extends AST

case class DyadicModifier(name: String, elem1: AST, elem2: AST) extends AST

case class TriadicModifier(name: String, elem1: AST, elem2: AST, elem3: AST) extends AST

case class Lambda(body: List[AST], kind: LambdaKind) extends AST

enum LambdaKind {
  case Normal, Map, Filter, Sort, OneByte, TwoByte
}
