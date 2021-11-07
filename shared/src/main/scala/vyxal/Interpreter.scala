package vyxal

object Interpreter {
  def interpret(code: String, inputs: List[VAny]): Stack = {
    ???
  }

  def execute(ast: AST, stack: Stack)(using ctx: Context): Unit = {
    ast match {
      case Element(name)  => Builtins.element(name)(stack)
      case Commands(cmds) => ???
    }
  }
}
