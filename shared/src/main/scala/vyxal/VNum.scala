package vyxal

case class VNum private (val numer: BigInt, val denom: BigInt) {
  def unary_- : VNum = VNum(-numer, denom)

  def +(that: VNum): VNum = that match {
    case VNum(num, den) =>
      VNum(numer * den + num * denom, denom * den)
  }

  def -(that: VNum): VNum = that match {
    case VNum(num, den) =>
      VNum(num * denom - numer * den, denom * den)
  }

  def *(that: VNum): VNum = that match {
    case VNum(num, den) => VNum(numer * num, denom * den)
  }

  def /(that: VNum): VNum = that match {
    case VNum(num, den) => VNum(numer * den, denom * num)
  }

  def /(div: Int): VNum = VNum(numer, denom * div)

  def <(that: VNum): Boolean = (that - this).isPositive
  def >(that: VNum): Boolean = (this - that).isPositive

  def toInt: Int = (numer / denom).toInt

  def to(exclusiveEnd: VNum, step: VNum = VNum(1)): VList =
    VList(
      Seq.unfold(this)(last =>
        Option.when(last < exclusiveEnd)((last, last + step))
      )
    )

  def isPositive: Boolean = this.numer > 0

  override def canEqual(other: Any) = other.isInstanceOf[VNum]

  override def equals(other: Any) =
    other match {
      case VNum(num, den) => this.numer == num && this.denom == den
      case i: Int => this.denom == 1 && this.numer == i
      case b: BigInt => this.denom == 1 && this.numer == b
      case _ => false
    }

  override def toString =
    if (denom == 1) numer.toString
    else s"$numer/$denom"
}

object VNum {
  def apply(numer: BigInt, denom: BigInt): VNum = {
    assert(denom != 0, "Division by zero is not defined")
    val gcd = numer.gcd(denom)
    val num = numer / gcd
    val den = denom / gcd
    if (den < 0) new VNum(-num, -den)
    else new VNum(num, den)
  }
  def apply(numer: Int): VNum = VNum(BigInt(numer), BigInt(1))

  /** Least common multiple because BigInt doesn't have its own */
  private def lcm(x: BigInt, y: BigInt): BigInt = (x * y) / x.gcd(y)
}

given CanEqual[VNum, Int] = CanEqual.derived
given CanEqual[Int, VNum] = CanEqual.derived
given CanEqual[VNum, BigInt] = CanEqual.derived
given CanEqual[BigInt, VNum] = CanEqual.derived
