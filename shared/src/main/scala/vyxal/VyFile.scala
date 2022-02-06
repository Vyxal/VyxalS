package vyxal

case class VyFile(contents: AST, astPositions: Map[AST, Pos])
