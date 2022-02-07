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
        case Literal(value) => println("literal:" + value); ctx.push(value); println(ctx)
        case l: Lambda => ctx.push(VFun.Lam(l))
        case Element(name) => Builtins.getElement(name)()
        case Cmds(cmds*) => cmds.foreach(execute)
        case Modified(onExec, _, _, arity) => onExec()
        case LambdaWithOp(lam, after) =>
          execute(lam)
          execute(after)
        case VarGet(varName) =>
          ctx.push(ctx.vars(varName))
        case VarSet(varName) => ctx.vars += (varName -> ctx.pop())
        case fn: FnDef =>
          ctx.vars += (fn.name -> VFun.FnRef(fn))
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
        case ExecFn() =>
          ctx.pop() match {
            case vf: VFun => vf match {
              case VFun.FnRef(fn) =>
                fn.arityOrParams match {
                  case List(arity: Int) =>
                    execute(fn.body)
                  case _ =>
                    for (param <- fn.arityOrParams) {
                      param match {
                        case s: String => execute(VarSet(s))
                        case n: Int => ctx.push(VNum(n))
                      }
                    }
                    execute(fn.body)
                }
              case _ => ???
            }
            case _ => Builtins.getElement("†")()
          }
      }
    } catch {
      case e: Exception =>
        throw Exception(s"Errored while executing element $ast, ctx=$ctx", e)
      case re: RuntimeException =>
        throw RuntimeException(s"Errored while executing element $ast, ctx=$ctx", re)
      case e: Error =>
        throw Error(s"Errored while executing element $ast, ctx=$ctx", e)
    }
  }
}
