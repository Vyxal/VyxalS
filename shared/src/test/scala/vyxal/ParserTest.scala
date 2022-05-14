package vyxal

import org.scalatest.flatspec.AnyFlatSpec

class ParserTest extends AnyFlatSpec {
  given Backend = new Backend {}

  def test(code: String, expected: AST) = {
    code should "parse correctly" in {
      val parsed = VParser.parse(code).contents
      assertResult(expected)(parsed)
    }
  }
  test(
    "(foo | bar} [a+ | a324} { 3",
    Cmds(
        For(Some("foo"), Cmds(Element("b"), Element("a"), Element("r"))),
        If(
          Cmds(Element("a"), Element("+")),
          Cmds(Element("a"), Literal(VNum(324, 1)))
        ),
        While(
          None,
          Literal(VNum(3, 1))
        )
      )
  )

  test(
    "+¤",
    Lambda(Element("+"), LambdaKind.OneElement)
  )

  test(
    "+-¢",
    Lambda(Cmds(Element("+"), Element("-")), LambdaKind.TwoElement)
  )

  test(
    "+¤+¢¤",
    Lambda(
      Cmds(Element("+"), Element("+")),
      LambdaKind.OneElement
    )
  )

}
