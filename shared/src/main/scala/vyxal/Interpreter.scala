package vyxal

import vyxal.Helpers.toBool

object Interpreter {
  def interpret(code: String, inputs: List[VAny]): Context = {
    val VyFile(ast, _) = Parser.parse(code)
    given ctx: Context = Context()
    execute(ast)
    ctx
  }

  def execute(ast: AST)(using ctx: Context): Unit = {
    try {
      ast match {
        case Literal(value) => ctx.push(value)
        case l: Lambda => ctx.push(VFun.Lam(l))
        case Element(name) => Builtins.getElement(name)()
        case MonadicModifier(name, elem1) =>
          Builtins.monadicModifiers(name)(elem1)
        case DyadicModifier(name, elem1, elem2) =>
          Builtins.dyadicModifiers(name)(elem1, elem2)
        case TriadicModifier(name, elem1, elem2, elem3) =>
          Builtins.triadicModifiers(name)(elem1, elem2, elem3)
        case Cmds(cmds*) => cmds.foreach(execute)
        case LambdaWithOp(lam, after) =>
          execute(lam)
          execute(after)
        case VarGet(varName) =>
          ctx.push(ctx.vars(varName))
        case VarSet(varName) => ctx.vars += (varName -> ctx.pop())
        case fn @ FnDef(name, arity, params, body) =>
          ctx.vars += (name -> VFun.FnRef(fn, arity))
        case If(truthy, falsey) =>
          execute(
            if (ctx.pop().toBool) truthy
            else falsey
          )
        case While(cond, body) =>
          cond match {
            case Some(condAst) =>
              while {
                execute(condAst)
                ctx.pop().toBool
              } do execute(body)
            case None =>
              while (true) execute(body)
          }
        case For(loopVar, body) =>
          val elems = ctx.pop()
          ???
      }
    } catch {
      case re: RuntimeException =>
        throw RuntimeException(s"Errored while executing element $ast", re)
    }
  }
}
