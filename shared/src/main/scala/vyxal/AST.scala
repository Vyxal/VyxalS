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

case class If(truthy: AST, falsey: AST) extends AST {
  override def toVyxal = s"[${truthy.toVyxal}|${falsey.toVyxal}]"
}

/** A for loop
  * @param loopVar
  *   The name of the variable to loop over
  * @param body
  *   The body of the loop
  */
case class For(loopVar: Option[String], body: AST) extends AST {
  override def toVyxal = "(" + loopVar.fold("")(_ + "|") + body.toVyxal + ")"
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
    arity: Int,
    params: Option[List[String]],
    body: AST
) extends AST {
  override def toVyxal = {
    val paramsStr = params.fold(s"$arity")(_.mkString(" "))
    s"@$name:$paramsStr|${body.toVyxal};"
  }
}

case class Modified(
    onExec: () => Context ?=> Unit,
    modName: String,
    elems: Seq[AST]
) extends AST {
  override def toVyxal = modName + elems.map(_.toVyxal).mkString("")
}

case class Lambda(body: AST, kind: LambdaKind) extends AST {
  override def toVyxal =
    kind match {
      case LambdaKind.Normal => "λ" + body.toVyxal + ";"
      case LambdaKind.OneByte => "⁽" + body.toVyxal
      case LambdaKind.TwoByte => "‡" + body.toVyxal
      case LambdaKind.ThreeByte => "≬" + body.toVyxal
    }
}

enum LambdaKind {
  case Normal, OneByte, TwoByte, ThreeByte
}

/** A lambda after which an element runs (map, filter, and sort lambdas)
  */
case class LambdaWithOp(lam: Lambda, after: AST) extends AST {
  override def toVyxal = lam.toVyxal + after.toVyxal
}
