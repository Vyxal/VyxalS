package vyxal

object Helpers {
  given boolToNum: Conversion[Boolean, VAny] = bool => VNum(if (bool) 1 else 0, 1)
  given intToNum: Conversion[Int, VAny] = VNum(_, 1)

  extension (any: VAny) {
    def toBool: Boolean = any match {
      case num: VNum => num != 0
      case str: String => str.nonEmpty
      case lst: VList => lst.nonEmpty
      case fun: VFun => true
    }
  }
}