package vyxal

/** An AST representing Vyxal code
  */
sealed trait AST

case class Literal(value: VAny) extends AST

case class Element(symbol: String) extends AST

/** Groups multiple elements together
  */
case class Commands(cmds: AST*) extends AST

/** Represents variable access (←varName)
  */
case class VarGet(name: String) extends AST

/** Represents variable assignment (→varName)
  */
case class VarSet(name: String) extends AST

case class If(truthy: AST, falsey: AST) extends AST

/** A for loop
  * @param loopVar
  *   The name of the variable to loop over
  * @param body
  *   The body of the loop
  */
case class For(loopVar: Option[String], body: AST) extends AST

/** @param cond
  *   The code to run to test each time
  * @param body
  *   The code to run if the condition is true
  */
case class While(cond: Option[AST], body: AST) extends AST

case class FnDef(
    name: String,
    arity: Int,
    params: Option[List[String]],
    body: List[AST]
) extends AST

case class MonadicModifier(name: String, elem1: AST) extends AST

case class DyadicModifier(name: String, elem1: AST, elem2: AST) extends AST

case class TriadicModifier(name: String, elem1: AST, elem2: AST, elem3: AST)
    extends AST

case class Lambda(body: AST, kind: LambdaKind) extends AST

enum LambdaKind {
  case Normal, OneByte, TwoByte, ThreeByte
}

/** A lambda after which an element runs (map, filter, and sort lambdas)
  */
case class LambdaWithOp(lam: Lambda, after: AST) extends AST
