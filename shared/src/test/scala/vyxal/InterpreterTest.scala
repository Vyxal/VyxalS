package vyxal

import org.scalatest.flatspec.AnyFlatSpec

class InterpreterTest extends AnyFlatSpec {
  given Backend = new Backend {}

  "random stuff" should "execute properly" in {
    val parsed = Parser
      .parse(raw"""
      3 2 +
      """)
      .contents
    given Backend with {
      override def print(s: String) = {} // bad code
    }
    given ctx: Context = Context()
    Interpreter.execute(parsed)
    val top = ctx.pop()
    assert(top == VNum(5))
  }

  "triple function" should "execute properly" in {
    val parsed = Parser
      .parse(raw"""
      @triple|3 *;
      4 ←triple†
      """)
      .contents
    println(parsed)
    given Backend with {
      override def print(s: String) = {} // bad code
    }
    given ctx: Context = Context()
    Interpreter.execute(parsed)
    val top = ctx.pop()
    assert(top == VNum(12))
  }
}
