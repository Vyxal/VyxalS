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

  def toInt: Int = (numer / denom).toInt

  override def equals(other: Any) =
    other match {
      case VNum(num, den) => this.numer == num && this.denom == den
      case i: Int         => this.denom == 1 && this.numer == i
      case b: BigInt      => this.denom == 1 && this.numer == b
      case _              => false
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

given CanEqual[VNum, Int] = CanEqual.derived
given CanEqual[Int, VNum] = CanEqual.derived
given CanEqual[VNum, BigInt] = CanEqual.derived
given CanEqual[BigInt, VNum] = CanEqual.derived
