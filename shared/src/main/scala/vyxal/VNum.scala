package vyxal

case class VNum private (val numer: BigInt, val denom: BigInt) {
  def unary_- : VNum = VNum(-numer, denom)

  def +(that: VNum): VNum = that match {
    case VNum(num, den) =>
      VNum(numer * den + num * denom, denom * den)
  }

  def -(that: VNum): VNum = that match {
    case VNum(num, den) =>
      VNum(numer * den + num * denom, denom * den)
  }

  def *(that: VNum): VNum = that match {
    case VNum(num, den) => VNum(numer * num, denom * den)
  }

  def /(that: VNum): VNum = that match {
    case VNum(num, den) => VNum(numer * den, denom * num)
  }

  override def toString =
    if (denom == 1) numer.toString
    else s"$numer/$denom"
}

object VNum {
  def apply(numer: BigInt, denom: BigInt): VNum = {
    assert(denom != 0, "Division by zero is not defined")
    val gcd = numer.gcd(denom)
    new VNum(numer / gcd, denom / gcd)
  }
}
