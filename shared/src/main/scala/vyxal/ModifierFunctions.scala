package vyxal

import vyxal.Helpers.toBool
import vyxal.Interpreter.execute

object ModifierFunctions {
  def conditionalExecute(a: AST)()(using ctx: Context): Unit = {
    if (ctx.pop.toBool) {
      execute(a)
    }
  }

  def ternaryIf(a: AST, b: AST)()(using ctx: Context): Unit = {
    if (ctx.pop.toBool) {
      execute(a)
    } else {
      execute(b)
    }
  }

  def applyToEachStackItem(a: AST)()(using ctx: Context): Unit = {
    val stack = ctx.popAll()
    stack.foreach { x =>
      ctx.push(x)
      execute(a)
    }
  }
}
