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
      override def print(s: String) = {}
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
    given Backend with {
      override def print(s: String) = {}
    }
    given ctx: Context = Context()
    Interpreter.execute(parsed)
    val top = ctx.pop()
    assert(top == VNum(12))
  }

  "conditional execute modifier" should "work" in {
    var parsed = Parser.parse(raw"1 3 2 +¿").contents
    given Backend with {
      override def print(s: String) = {}
    }
    given ctx: Context = Context()
    Interpreter.execute(parsed)
    var top = ctx.pop()
    assert(top == VNum(4))

    parsed = Parser.parse(raw"1 3 0 +¿").contents
    Interpreter.execute(parsed)
    top = ctx.pop()
    assert(top == VNum(3))

    // eventually these tests will be auto-generated from the YAML
  }
}
