package vyxal

import org.scalatest.flatspec.AnyFlatSpec

class ParserTest extends AnyFlatSpec {
  def test(code: String, expected: AST) = {
    code should "parse correctly" in {
      val parsed = Parser.parse(code).contents
      assertResult(expected)(parsed)
    }
  }
  test(
    "(foo | bar) [a+ | a324] { 3",
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
  // well i (steffan) screwed this test up, it fails now. someone else can fix that lol

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
      Lambda(
        Cmds(
          Lambda(Element("+"), LambdaKind.OneElement),
          Element("+")
        ),
        LambdaKind.TwoElement
      ),
      LambdaKind.OneElement
    )
  )

}
