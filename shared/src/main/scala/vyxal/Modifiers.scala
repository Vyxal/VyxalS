package vyxal

import vyxal.Helpers.toBool
import vyxal.Interpreter.execute

object Modifiers {
  val monadicModifiers: Map[String, AST => AST] = Map(
    "¤" -> (a => Lambda(a, LambdaKind.OneElement)),
    "¿" -> (a => Modified(conditionalExecute(a), "¿", Seq(a), 1)),
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

  private def conditionalExecute(a: AST)()(using ctx: Context): Unit = {
    if (ctx.pop.toBool) {
      println("true")
      execute(a)
    }
    // TODO: outsource these methods into another file
  }
}
