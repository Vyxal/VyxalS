package vyxal

/** An AST representing Vyxal code
  */
sealed trait AST {
  def textRange: TextRange
}

case class Pos(row: Int, col: Int)

case class TextRange(start: Pos, end: Pos)

object TextRange {
  def synthetic = TextRange(Pos(0, 0), Pos(0, 0))
}

case class Literal(value: VAny, textRange: TextRange = TextRange.synthetic)
    extends AST

case class Element(symbol: String, textRange: TextRange = TextRange.synthetic)
    extends AST

/** Groups multiple elements together
  */
case class Cmds(cmds: AST*) extends AST {
  override def textRange =
    TextRange(cmds.head.textRange.start, cmds.last.textRange.end)
}

object Cmds {
  def empty = Cmds()
}

/** Represents variable access (←varName)
  */
case class VarGet(name: String, textRange: TextRange = TextRange.synthetic)
    extends AST

/** Represents variable assignment (→varName)
  */
case class VarSet(name: String, textRange: TextRange = TextRange.synthetic)
    extends AST

/** Execute the top of the stack (or just run element †) */
case class ExecFn(textRange: TextRange = TextRange.synthetic) extends AST

case class If(
    truthy: AST,
    falsey: AST,
    textRange: TextRange = TextRange.synthetic
) extends AST

/** A for loop
  * @param loopVar
  *   The name of the variable to loop over
  * @param body
  *   The body of the loop
  */
case class For(
    loopVar: Option[String],
    body: AST,
    textRange: TextRange = TextRange.synthetic
) extends AST

/** @param cond
  *   The code to run to test each time
  * @param body
  *   The code to run if the condition is true
  */
case class While(
    cond: Option[AST],
    body: AST,
    textRange: TextRange = TextRange.synthetic
) extends AST

case class FnDef(
    name: String,
    arityOrParams: List[Int | String],
    body: AST,
    textRange: TextRange = TextRange.synthetic
) extends AST {
  def arity: Int = arityOrParams match {
    case List(arity: Int) => arity
    case ps               => 1.max(ps.count(_.isInstanceOf[String]))
  }
}

case class Lambda(
    body: AST,
    kind: LambdaKind = LambdaKind.Normal,
    textRange: TextRange = TextRange.synthetic
) extends AST

enum LambdaKind {
  case Normal, OneElement, TwoElement, ThreeElement, FourElement
}

/** A lambda after which an element runs (map, filter, and sort lambdas)
  */
case class LambdaWithOp(
    lam: Lambda,
    after: AST,
    textRange: TextRange = TextRange.synthetic
) extends AST

enum Modifier(symbol: String) extends AST {
  case ConditionalExecute(body: AST, textRange: TextRange = TextRange.synthetic)
      extends Modifier("¿")
  case ApplyToEachStackItem(
      body: AST,
      textRange: TextRange = TextRange.synthetic
  ) extends Modifier("æ")
}
