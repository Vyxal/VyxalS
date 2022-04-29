package vyxal

//TODO make a REPL
object JVMMain {
  def main(args: Array[String]): Unit = {
    println("Hello from the JVM!")

    // Import the implicit conversion from Int to VNum
    import vyxal.Helpers.intToNum
    import vyxal.given

    // I know there's a lot of nested Seq's here, but that can be sugared later
    // and this won't even be used that often

    given Backend with {
      override def print(s: String) = Predef.print(s)
    }

    given ctx: Context = Context(Seq(VList.of(1, 2, 3)))

    Interpreter.execute("∑")

    // println(ctx.peek) // should be 6
  }
}
