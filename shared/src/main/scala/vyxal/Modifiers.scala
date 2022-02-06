package vyxal

object Modifiers {
  val monadicModifiers: Map[String, AST => AST] = Map(
    "⁽" -> (a => Lambda(a, LambdaKind.OneByte))
  )

  val dyadicModifiers: Map[String, (AST, AST) => AST] = Map(
    "‡" -> ((a, b) => Lambda(Cmds(a, b), LambdaKind.TwoByte))
  )

  val triadicModifiers: Map[String, (AST, AST, AST) => AST] = Map(
    "≬" -> ((a, b, c) => Lambda(Cmds(a, b, c), LambdaKind.ThreeByte))
  )
}
