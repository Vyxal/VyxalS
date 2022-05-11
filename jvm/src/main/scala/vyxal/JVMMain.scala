package vyxal

//TODO make a REPL
object JVMMain {
  private given Backend with {
    override def print(s: String) = Console.print(s)

    override def err(s: String) = Console.err.print(s)

    override def warn(s: String) = Console.print(Console.YELLOW + s)
  }

  def main(args: Array[String]): Unit = {
    println("Hello from the JVM!")

    given ctx: Context = Context()

    var line = scala.io.StdIn.readLine()

    while (line != null) {
      Interpreter.executeLine(line)(using ctx)
      line = scala.io.StdIn.readLine()
    }
  }
}
