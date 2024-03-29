package vyxal

/** An AST representing Vyxal code
  */
sealed trait AST {

  /** Back into Vyxal code */
  def toVyxal: String
}

case class Literal(value: VAny) extends AST {
  override def toVyxal = value.toString
}

case class Element(symbol: String) extends AST {
  override def toVyxal = symbol
}

/** Groups multiple elements together
  */
case class Cmds(cmds: AST*) extends AST {
  override def toVyxal = cmds.map(_.toVyxal).mkString(" ")
}

object Cmds {
  def empty = Cmds()
}

/** Represents variable access (←varName)
  */
case class VarGet(name: String) extends AST {
  override def toVyxal = s"←$name"
}

/** Represents variable assignment (→varName)
  */
case class VarSet(name: String) extends AST {
  override def toVyxal = s"→$name"
}

/** Execute the top of the stack (or just run element †) */
case class ExecFn() extends AST {
  override def toVyxal = "†"
}

case class If(truthy: AST, falsey: AST) extends AST {
  override def toVyxal = s"[${truthy.toVyxal}|${falsey.toVyxal}}"
}

/** A for loop
  * @param loopVar
  *   The name of the variable to loop over
  * @param body
  *   The body of the loop
  */
case class For(loopVar: Option[String], body: AST) extends AST {
  override def toVyxal = "(" + loopVar.fold("")(_ + "|") + body.toVyxal + "}"
}

/** @param cond
  *   The code to run to test each time
  * @param body
  *   The code to run if the condition is true
  */
case class While(cond: Option[AST], body: AST) extends AST {
  override def toVyxal =
    "{" + cond.fold("")(_.toVyxal + "|") + body.toVyxal + "}"
}

case class FnDef(
    name: String,
    arityOrParams: List[Int | String],
    body: AST
) extends AST {
  def arity: Int = arityOrParams match {
    case List(arity: Int) => arity
    case ps => 1.max(ps.count(_.isInstanceOf[String]))
  }

  override def toVyxal =
    arityOrParams
      .map(_.toString)
      .mkString(s"@$name:", ":", s"|${body.toVyxal}}")
}

case class Modified(
    onExec: () => Context ?=> Unit,
    modName: String,
    elems: Seq[AST],
    arity: Int
) extends AST {
  override def toVyxal = elems.map(_.toVyxal).mkString("") + modName
}

case class Lambda(body: AST, kind: LambdaKind) extends AST {
  override def toVyxal =
    kind match {
      case LambdaKind.Normal => "λ" + body.toVyxal + "}"
      case LambdaKind.OneElement => body.toVyxal + "¤"
      case LambdaKind.TwoElement => body.toVyxal + "¢"
      case LambdaKind.ThreeElement => body.toVyxal + "€"
      case LambdaKind.FourElement => body.toVyxal + "§"
    }
}

enum LambdaKind {
  case Normal, OneElement, TwoElement, ThreeElement, FourElement
}

/** A lambda after which an element runs (map, filter, and sort lambdas)
  */
case class LambdaWithOp(lam: Lambda, after: AST) extends AST {
  override def toVyxal = lam.toVyxal + after.toVyxal
}
