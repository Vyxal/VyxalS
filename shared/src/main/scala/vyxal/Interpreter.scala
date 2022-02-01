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
    try {
      ast match {
        case Literal(value) => stack.push(value)
        case l: Lambda => stack.push(VFun.Lam(l))
        case Element(name) => Builtins.getElement(name)()
        case MonadicModifier(name, elem1) =>
          Builtins.monadicModifiers(name)(elem1)
        case DyadicModifier(name, elem1, elem2) =>
          Builtins.dyadicModifiers(name)(elem1, elem2)
        case TriadicModifier(name, elem1, elem2, elem3) =>
          Builtins.triadicModifiers(name)(elem1, elem2, elem3)
        case Commands(cmds) => cmds.foreach(execute)
        case LambdaWithOp(lam, after) =>
          execute(lam)
          execute(after)
        case VarGet(varName) =>
          stack.push(ctx.vars(varName))
        case VarSet(varName) => ctx.vars += (varName -> stack.pop())
        case fn@FnDef(name, arity, params, body) =>
          ctx.vars += (name -> VFun.FnRef(fn, arity))
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
    } catch {
      case re: RuntimeException =>
        throw RuntimeException(s"Errored while executing element $ast", re)
    }
  }

  def execute(asts: List[AST])(using Context): Unit = asts.foreach(execute)
}
