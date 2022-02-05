package vyxal

import org.scalatest.flatspec.AnyFlatSpec

class ParserTest extends AnyFlatSpec {
  def test(code: String, expected: AST) = {
    code should "parse correctly" in {
      val parsed = Parser.parse(code)
      assertResult(parsed)(expected)
    }
  }
  test(
    "(foo | bar) [a+ | a324] { 3",
    Commands(
      For(Some("foo"), List(Element("b"), Element("a"), Element("r"))),
      If(
        List(Element("a"), Element("+")),
        List(Element("a"), Literal(VNum(324, 1)))
      ),
      While(
        None,
        List(Literal(VNum(3, 1)))
      )
    )
  )

  test(
    "⁽+",
    Commands(Lambda(List(Element("+")), LambdaKind.OneByte))
  )

}
