package vyxal

import vyxal.Helpers.toBool

object Interpreter {
  def interpret(code: String, inputs: List[VAny]): Context = {
    val ast = Parser.parse(code)
    given ctx: Context = Context()
    execute(ast)
    ctx
  }

  def execute(ast: AST)(using ctx: Context): Unit = {
    val stack = ctx.stack
    ast match {
      case Literal(value) => stack.push(value)
      case Element(name) => Builtins.element(name)()
      case MonadicModifier(name, elem1) =>
        Builtins.monadicModifiers(name)(elem1)
      case DyadicModifier(name, elem1, elem2) =>
        Builtins.dyadicModifiers(name)(elem1, elem2)
      case TriadicModifier(name, elem1, elem2, elem3) =>
        Builtins.triadicModifiers(name)(elem1, elem2, elem3)
      case Commands(cmds) => cmds.foreach(execute)
      case VarGet(varName) =>
        stack.push(ctx.vars(varName))
      case VarSet(varName) => ctx.vars += (varName -> stack.pop())
      case If(truthy, falsey) =>
        execute(
          if (stack.pop().toBool) truthy
          else falsey
        )
      case While(cond, body) =>
        cond match {
          case Some(condAst) =>
            while {
              execute(condAst)
              stack.pop().toBool
            } do execute(body)
          case None =>
            while (true) execute(body)
        }
    }
  }

  def execute(asts: List[AST])(using Context): Unit = asts.foreach(execute)
}
