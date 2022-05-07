package vyxal

import org.scalatest.flatspec.AnyFlatSpec
import vyxal.Helpers.intToNum

class InterpreterTest extends AnyFlatSpec {
  given Backend = new Backend {}

  "random stuff" should "execute properly" in {
    var parsed = Parser
      .parse(raw"""
      3 2 +
      """)
      .contents
    given Backend with {
      override def print(s: String) = {}
    }
    given ctx: Context = Context()
    Interpreter.execute(parsed)
    var top = ctx.pop()
    assert(top == VNum(5))

    parsed = Parser.parse(raw"3 2 -").contents
    Interpreter.execute(parsed)
    top = ctx.pop()
    assert(top == VNum(1))
  }

  "triple function" should "execute properly" in {
    val parsed = Parser
      .parse(raw"""
      @triple|3 ×}
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
  }

  "ternary if modifier" should "work" in {
    var parsed = Parser.parse(raw"4 2 3]").contents
    given Backend with {
      override def print(s: String) = {}
    }
    given ctx: Context = Context()
    Interpreter.execute(parsed)
    var top = ctx.pop()
    assert(top == VNum(2))

    parsed = Parser.parse(raw"5 3 0 +-]").contents
    Interpreter.execute(parsed)
    top = ctx.pop()
    assert(top == VNum(2))

    parsed = Parser.parse(raw"5 3 9 +-]").contents
    Interpreter.execute(parsed)
    top = ctx.pop()
    assert(top == VNum(8))
  }

  "apply to each stack item modifier" should "work" in {
    var parsed = Parser.parse(raw"2 4 6 8 ½æ W").contents
    given Backend with {
      override def print(s: String) = {}
    }
    given ctx: Context = Context()
    Interpreter.execute(parsed)
    var top = ctx.pop()
    assert(top == VList.of(1, 2, 3, 4))

    parsed = Parser.parse(raw"5 1 7 2 4 2+¢æ W").contents
    Interpreter.execute(parsed)
    top = ctx.pop()
    assert(top == VList.of(7, 3, 9, 4, 6))

    // TODO: currently modifiers that take a lambda don't work
  }

  // TODO: auto-generate some of these tests from the YAML
}
