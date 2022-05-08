package vyxal.num

import scala.collection.immutable.LazyList

import vyxal.VList

sealed trait VNum {
  def unary_- : VNum = this match {
    case Frac(numer, denom) => Frac(-numer, denom)
    case Sum(terms) => Sum(terms.map(term => -term))
    case p: Prod => Integer(-1) * p
  }

  def +(that: VNum): VNum = (this, that) match {
    case (Frac(num1, den1), Frac(num2, den2)) =>
      Frac(num1 * den2 + num2 * den1, den1 * den2)
  }

  def -(that: VNum): VNum = (this, that) match {
    case (Frac(num1, den1), Frac(num2, den2)) =>
      Frac(num1 * den2 - num2 * den1, den1 * den2)
  }

  def *(that: VNum): VNum = Prod(this, that)

  def /(that: VNum): VNum = Frac(this, that)

  private def compare(that: VNum): Int = {
    // todo implement this properly
    val diff = this.toDouble - that.toDouble
    if (diff > 0.0) 1
    else if (diff == 0.0) 0
    else -1
  }

  def <(that: VNum): Boolean = this.compare(that) < 0

  def >(that: VNum): Boolean = this.compare(that) > 0

  def <=(that: VNum): Boolean = this.compare(that) <= 0

  def >=(that: VNum): Boolean = this.compare(that) >= 0

  def toDouble: Double = this match {
    case Frac(numer, denom) => ???
  }

  def toLong: Long = this.toDouble.toLong

  def toInt: Int = this.toLong.toInt

  def isZero: Boolean = this == Zero

  /** Whether this number is either positive or negative infinity */
  def isInf: Boolean = this == PosInf || this == NegInf

  /** Greatest common divisor */
  def gcd(that: VNum): VNum = (this, that) match {
    case (Integer(n1), Integer(n2)) => Integer(n1.gcd(n2))
  }

  /** Range from this number (inclusive) to another number (exclusive) */
  def to(endExclusive: VNum): VList = ???

  override def equals(obj: Any) = obj match {
    case y: VNum =>
      this match {
        // todo implement all possible cases in a cleaner way
        case Frac(num1, den1) =>
          y match {
            case Frac(num2, den2) => num1 == num1 && den1 == den2
          }
        case Sum(terms1) =>
          y match {
            case Sum(terms2) => terms1 `eq` terms2 // todo
          }
      }
    case _ => false
  }
}

object Zero extends VNum

/** Positive infinity */
object PosInf extends VNum

/** Negative infinity */
object NegInf extends VNum

case class Integer private (value: BigInt) extends VNum

object Integer {
  def apply(value: BigInt): VNum =
    if (value == 0) Zero
    else new Integer(value)
}

/** A fraction
  */
case class Frac private (numer: VNum, denom: VNum) extends VNum

object Frac {
  def apply(numer: VNum, denom: VNum) = (numer, denom) match {
    case (Zero, Zero) =>
      throw IllegalArgumentException(
        s"Numerator ($numer) and denomeFracor ($denom) are both 0"
      )
    case (Zero, _) => Zero
    case (n, Zero) if n > 0 => PosInf
    case (n, Zero) if n < 0 => NegInf
    case _ =>
      val gcd = numer.gcd(denom)
      new Frac(numer / gcd, denom / gcd)
  }
}

/** An imaginary number
  */
case class Imag(times: Frac) extends VNum

/** base raised to the power of pow */
case class Pow(base: VNum, pow: VNum) extends VNum

/** The sum of a finite number of terms. The constructor is private to ensure
  * Sums won't ever be nested.
  */
case class Sum private[num] (terms: Seq[VNum]) extends VNum

/** The product of a finite number of terms. The constructor is private to
  * ensure Prods won't ever be nested.
  */
case class Prod private (terms: Seq[VNum]) extends VNum

object Prod {

  /** A product of just two terms */
  def apply(x: VNum, y: VNum): VNum = (x, y) match {
    case (Frac(num1, den1), Frac(num2, den2)) =>
      Frac(Prod(num1, num2), Prod(den1, den2))
    case (Frac(num, den), _) => Frac(Prod(num, y), den)
    case (_, Frac(num, den)) => Frac(Prod(x, num), den)
    case (Prod(terms1), Prod(terms2)) => new Prod(terms1 ++ terms2)
    case (p: Prod, _) => prodSingle(y, p)
    case (_, p: Prod) => prodSingle(x, p)
    case (Integer(n1), Integer(n2)) => Integer(n1 * n2)
  }

  private def prodSingle(x: VNum, y: Prod): VNum = {
    if (x.isZero) Integer(0)
  }
}

/** An infinite convergent series using a spigot algorithm.
  * @param approx
  *   A precomputed approximation of the series
  * @param intPart
  *   The part before the decimal point
  * @param digits
  *   All the digits after the decimal point
  * @param base
  *   The base that the digits are in
  */
case class Series private[num] (
    approx: Double,
    intPart: BigInt,
    digits: LazyList[Int],
    base: Int = 10
) extends VNum

object VNum {
  def int(i: Int) = Integer(i)

  def double(d: Double) = ???

  def frac(numer: BigInt, denom: BigInt) = Frac(Integer(numer), Integer(denom))

  def parse(str: String): Option[VNum] = ???

  given CanEqual[VNum, Int] = CanEqual.derived
  given CanEqual[Int, VNum] = CanEqual.derived
  given CanEqual[VNum, BigInt] = CanEqual.derived
  given CanEqual[BigInt, VNum] = CanEqual.derived

  given boolToNum: Conversion[Boolean, VNum] =
    bool => if (bool) VNum.int(1) else VNum.int(0)

  given intToNum: Conversion[Int, VNum] =
    numer => VNum.frac(numer, 1)

  given numeric: Numeric[VNum] with {
    override def compare(x: VNum, y: VNum) = x.compare(y)

    override def negate(x: VNum) = -x

    override def plus(x: VNum, y: VNum) = x + y

    override def minus(x: VNum, y: VNum) = x - y

    override def times(x: VNum, y: VNum) = x * y

    override def fromInt(x: Int) = VNum.int(x)

    override def toDouble(x: VNum) = x.toDouble

    override def toLong(x: VNum) = x.toLong

    override def toFloat(x: VNum) = x.toDouble.toFloat

    override def toInt(x: VNum) = x.toLong.toInt

    override def parseString(str: String) = VNum.parse(str)
  }
}
