package vyxal

//TODO make a REPL
object JVMMain {
  def main(args: Array[String]): Unit = {
    println("Hello from the JVM!")

    // Import the implicit conversion from Int to VNum
    import vyxal.Helpers.intToNum
    import vyxal.given

    println(
      VNum(1, 2) match {
        case x: VAtom => s"Success!: $x"
        case _ => "oh noes"
      }
    )

    // I know there's a lot of nested Seq's here, but that can be sugared later
    // and this won't even be used that often
    
    val stack = Stack(Seq(VList(Seq(1, 2, 3))))

    Interpreter.execute(Element("∑"), stack)(using
      Context()
    )

    println(stack) //should be 6
  }
}
