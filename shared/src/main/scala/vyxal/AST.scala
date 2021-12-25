package vyxal

/** An AST representing Vyxal code
  */
sealed trait AST

case class NumLiteral(num: VNum) extends AST

case class Element(symbol: String) extends AST

/** Basically a line of Vyxal code
  */
case class Commands(cmds: List[AST]) extends AST

case class VarGet(name: String) extends AST

case class VarSet(name: String) extends AST

case class If(truthy: List[AST], falsey: List[AST]) extends AST

case class For(loopVar: Option[String], body: List[AST]) extends AST

case class While(cond: Option[List[AST]], body: List[AST]) extends AST

case class FnDef(params: Option[List[String]], body: List[AST]) extends AST

case class FnRef(name: String) extends AST

case class MonadicModifier(elem1: AST) extends AST

case class DyadicModifier(elem1: AST, elem2: AST) extends AST

case class TriadicModifier(elem1: AST, elem2: AST, elem3: AST) extends AST

case class ListLiteral(elems: List[AST]) extends AST

case class Lambda(body: List[AST], kind: LambdaKind) extends AST

enum LambdaKind {
  case Normal, Map, Filter, Sort, OneByte, TwoByte
}
