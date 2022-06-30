package vyxal

/** An AST representing Vyxal code
  */
sealed trait AST

case class Literal(value: VAny) extends AST

case class Element(symbol: String) extends AST

/** Groups multiple elements together
  */
case class Cmds(cmds: AST*) extends AST

object Cmds {
  def empty = Cmds()
}

/** Represents variable access (←varName)
  */
case class VarGet(name: String) extends AST

/** Represents variable assignment (→varName)
  */
case class VarSet(name: String) extends AST

/** Execute the top of the stack (or just run element †) */
case class ExecFn() extends AST

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
    arityOrParams: List[Int | String],
    body: AST
) extends AST {
  def arity: Int = arityOrParams match {
    case List(arity: Int) => arity
    case ps => 1.max(ps.count(_.isInstanceOf[String]))
  }
}

case class Lambda(body: AST, kind: LambdaKind) extends AST

enum LambdaKind {
  case Normal, OneElement, TwoElement, ThreeElement, FourElement
}

/** A lambda after which an element runs (map, filter, and sort lambdas)
  */
case class LambdaWithOp(lam: Lambda, after: AST) extends AST

enum Modifier(symbol: String) extends AST {
  case ConditionalExecute(body: AST) extends Modifier("¿")
  case ApplyToEachStackItem(body: AST) extends Modifier("æ")
}

case class Modified(
    onExec: () => Context ?=> Unit,
    modName: String,
    elems: Seq[AST],
    arity: Int
) extends AST
