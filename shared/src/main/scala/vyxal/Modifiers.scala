package vyxal

object Modifiers {
  val monadicModifiers: Map[String, AST => AST] = Map(
    "¤" -> (a => Lambda(a, LambdaKind.OneElement))
  )

  val dyadicModifiers: Map[String, (AST, AST) => AST] = Map(
    "¢" -> ((a, b) => Lambda(Cmds(a, b), LambdaKind.TwoElement))
  )

  val triadicModifiers: Map[String, (AST, AST, AST) => AST] = Map(
    "€" -> ((a, b, c) => Lambda(Cmds(a, b, c), LambdaKind.ThreeElement))
  )

  val tetradicModifiers: Map[String, (AST, AST, AST, AST) => AST] = Map(
    "§" -> ((a, b, c, d) => Lambda(Cmds(a, b, c, d), LambdaKind.FourElement))
  )
}
