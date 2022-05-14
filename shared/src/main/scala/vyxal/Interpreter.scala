package vyxal

import vyxal.Helpers.{toBool, toList}
import vyxal.num.VNum

object Interpreter {
  def execute(
      code: String,
      inputs: List[VAny] = List.empty,
      flags: List[String] = List.empty
  )(using Backend): Context = {
    val VyFile(ast, _) = Parser.parse(code)
    given ctx: Context = Context()
    execute(ast)
    if (!ctx.isStackEmpty) {
      ctx.println(ctx.peek)
    }
    ctx
  }

  def executeLine(
      line: String
  )(using ctx: Context): Context = {
    val VyFile(ast, _) = Parser.parse(line)
    execute(ast)
    if (!ctx.isStackEmpty) {
      ctx.println(ctx.pop())
    }
    ctx
  }

  def execute(ast: AST)(using ctx: Context): Unit = {
    println(s"executing ast $ast, ctx=$ctx")
    try {
      ast match {
        case Literal(value) =>
          println("literal:" + value); ctx.push(value); println(ctx)
        case l: Lambda => ctx.push(VFun.Lam(l, ctx.createChild()))
        case Element(name) => Builtins.getElement(name)()
        case Cmds(cmds*) => cmds.foreach(execute)
        case Modified(onExec, _, _, arity) => onExec()
        case LambdaWithOp(lam, after) =>
          execute(lam)
          execute(after)
        case VarGet(varName) =>
          ctx.push(ctx.getVar(varName))
        case VarSet(varName) => ctx.setVar(varName, ctx.pop())
        case fn: FnDef =>
          ctx.setVar(fn.name, VFun.FnRef(fn, ctx.createChild()))
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
          val elems = ctx.pop().toList
          for (elem <- elems) {
            given newCtx: Context = ctx.createChild(contextVar = elem)
            loopVar.map { varName => newCtx.setVar(varName, elem) }
            execute(body)
          }
        case ExecFn() =>
          ctx.pop() match {
            case vf: VFun =>
              vf match {
                case VFun.FnRef(fn, fnCtx) =>
                  val newCtx = Context.fnCallCtx(fnCtx, ctx)
                  fn.arityOrParams match {
                    case List(arity: Int) =>
                      execute(fn.body)(using newCtx)
                    case _ =>
                      for (param <- fn.arityOrParams) {
                        param match {
                          case s: String =>
                            newCtx.push(ctx.pop())
                            execute(VarSet(s))(using newCtx)
                          case n: Int => newCtx.push(VNum.int(n))
                        }
                      }
                      execute(fn.body)(using newCtx)
                      if (!newCtx.isStackEmpty) ctx.push(newCtx.pop())
                  }
                case _ => ???
              }
            case _ => Builtins.getElement("†")()
          }
      }
    } catch {
      case e: Exception =>
        throw Exception(
          s"Errored while executing element $ast, ctx=$ctx, e=${e.getMessage}",
          e
        )
      case re: RuntimeException =>
        throw RuntimeException(
          s"Errored while executing element $ast, ctx=$ctx",
          re
        )
      case e: Error =>
        throw Error(
          s"Errored while executing element $ast, ctx=$ctx, e=${e.getMessage}",
          e
        )
      case e =>
        throw Error(
          s"Magic Errored while executing element $ast, ctx=$ctx, e=${e.getMessage}",
          e
        )
    }
  }
}
