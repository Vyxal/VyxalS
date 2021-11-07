package vyxal

object Helpers {
  given intToNum: Conversion[Int, VAny] = VNum(_, 1)
}
