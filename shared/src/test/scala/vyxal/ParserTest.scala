package vyxal

import org.scalatest.flatspec.AnyFlatSpec

class ParserTest extends AnyFlatSpec {
  "structures and stuff" should "parse correctly" in {
    val parsed = Parser.parse(raw"""
      (foo | bar) [a+ | a324] { 3
      """)
    assert(
      parsed == Commands(
        List(
          For(
            Some("foo"),
            List(Element("b"), Element("a"), Element("r"))),
          If(
            List(Element("a"), Element("+")),
            List(Element("a"), NumLiteral(VNum(324, 1)))),
          While(
            None,
            List(NumLiteral(VNum(3, 1)))
          )
        )
      )
    )
  }
}
