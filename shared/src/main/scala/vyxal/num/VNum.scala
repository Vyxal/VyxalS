package vyxal.num

import scala.collection.immutable.LazyList

import vyxal.VList

sealed trait VNum {
  final def unary_- : VNum = this match {
    case Zero => Zero
    case PosInf => PosInf
    case NegInf => NegInf
    case Rat(num, den) => Rat(-num, den)
    case Imag(b) => Imag(-b)
    case s: Sum => Integer(-1) * s
    case IrratMulDiv(factor, nums, dens) => IrratMulDiv(-factor, nums, dens)
    case _ => VNum.int(-1) * this
  }

  final def +(that: VNum): VNum = (this, that) match {
    case (Zero, _) => that
    case (_, Zero) => this
    case (inf1 @ (PosInf | NegInf), inf2 @ (PosInf | NegInf)) =>
      if (inf1 != inf2)
        throw ArithmeticException("Cannot add infinities of opposite sign")
      else inf1
    case (Rat(num1, den1), Rat(num2, den2)) =>
      Rat(num1 * den2 + num2 * den1, den1 * den2)
  }

  final def -(that: VNum): VNum = this + (-that)

  final def *(that: VNum): VNum = (this, that) match {
    case (Zero, PosInf | NegInf) =>
      throw ArithmeticException(s"Cannot multiply 0 and infinity")
    case (PosInf | NegInf, Zero) =>
      throw ArithmeticException(s"Cannot multiply infinity and 0")
    case (Zero, _) => Zero
    case (_, Zero) => Zero
    case (inf @ (PosInf | NegInf), y) => if (y.sign > 0) inf else -inf
    case (x, inf @ (PosInf | NegInf)) => if (x.sign > 0) inf else -inf
    case (Integer(n1), Integer(n2)) => Integer(n1 * n2)
    case (Rat(num1, den1), Rat(num2, den2)) =>
      Rat(num1 * num2, den1 * den2)
    case (Integer(n), Rat(num, den)) => Rat(num * n, den)
    case (Rat(num, den), Integer(n)) => Rat(num * n, den)
    case (Imag(n1), Imag(n2)) => -(n1 * n2)
    case (Imag(n1), n2) => Imag(n1 * n2)
    case (n1, Imag(n2)) => Imag(n1 * n2)
    case (Sum(nonIrrat1, irrats1), Sum(nonIrrat2, irrats2)) =>
      Sum(nonIrrat1 * nonIrrat2, irrats1 ++ irrats2)
    case (IrratMulDiv(fact1, num1, den1), IrratMulDiv(fact2, num2, den2)) =>
      IrratMulDiv(fact1 * fact2, num1 ++ num2, den1 ++ den2)
    case (IrratMulDiv(fact, num, den), ir: Irrat) => IrratMulDiv(fact, ir +: num, den)
    case (ir: Irrat, IrratMulDiv(fact, num, den)) => IrratMulDiv(fact, ir +: num, den)
  }

  final def /(that: VNum): VNum = (this, that) match {
    case (Zero, Zero) =>
      throw ArithmeticException("Cannot divide 0 by 0")
    case (Zero, _) => Zero
    case (n, Zero) if n > 0 => PosInf
    case (n, Zero) if n < 0 => NegInf
    case (Imag(x), Imag(y)) => -(x * y)
    case (x, Imag(y)) => Imag(x * y)
    case (Imag(x), y) => Imag(x * y)
    case (Rat(num1, den1), Rat(num2, den2)) =>
      Rat(num1 * den2, num2 * den1)
  }

  private def compare(that: VNum): Int = {
    if (this `eq` that) return 0

    // todo implement this properly
    val diff = this.toDouble - that.toDouble
    if (diff > 0.0) 1
    else if (diff == 0.0) 0
    else -1
  }

  final def toDouble: Double = this match {
    case Zero => 0.0
    case PosInf => Double.PositiveInfinity
    case NegInf => Double.NegativeInfinity
    case Integer(n) => n.toDouble
    case Rat(numer, denom) => ???
    case _: Imag => throw ArithmeticException(s"Cannot convert imaginary number to double ($this)")
    case ir: Irrat => ir.toDouble
  }

  final def toLong: Long = this.toDouble.toLong

  final def toInt: Int = this.toDouble.toInt

  final def isZero: Boolean = Zero == this

  final def isNeg: Boolean = this < 0

  final def isPos: Boolean = this > 0

  /** Whether this number is either positive or negative infinity */
  def isInf: Boolean = PosInf == this || NegInf == this
  def isInt: Boolean = this.isInstanceOf[Integer]
  def isRat: Boolean = this.isInstanceOf[Rat]
  def isIrrat: Boolean = this.isInstanceOf[Irrat]
  def isReal: Boolean = this.isInstanceOf[Real]

  /** 1 if positive, 0 if zero, -1 if negative */
  def sign: (1 | 0 | -1) = this match {
    case Zero => 0
    case PosInf => 1
    case NegInf => -1
    case _ => ???
  }

  /** Range from this number (inclusive) to another number (exclusive) */
  def to(endExclusive: VNum): VList = ???

  // def equals(obj: Any) = {
  //   obj match {
  //     case y: VNum => this.compare(y) == 0
  //     case i: Int => this.equals(VNum.int(i))
  //     case d: Double => this.equals(VNum.double(d))
  //     case _ => false
  //   }
  // }

  final def <(that: VNum): Boolean = this.compare(that) < 0
  final def >(that: VNum): Boolean = this.compare(that) > 0
  final def <=(that: VNum): Boolean = this.compare(that) <= 0
  final def >=(that: VNum): Boolean = this.compare(that) >= 0
  final def +(that: Int): VNum = this + VNum.int(that)
  final def -(that: Int): VNum = this - VNum.int(that)
  final def *(that: Int): VNum = this * VNum.int(that)
  final def /(that: Int): VNum = this / VNum.int(that)
  final def <(that: Int): Boolean = this < VNum.int(that)
  final def >(that: Int): Boolean = this < VNum.int(that)
  final def <=(that: Int): Boolean = this < VNum.int(that)
  final def >=(that: Int): Boolean = this < VNum.int(that)
}

sealed trait Real extends VNum

sealed trait NonIrrat extends VNum

case object Zero extends Real, NonIrrat

/** Positive infinity */
case object PosInf extends VNum, NonIrrat

/** Negative infinity */
case object NegInf extends VNum, NonIrrat

case class Integer private[num] (num: BigInt) extends Real, NonIrrat

case class Rat private (numer: BigInt, denom: BigInt) extends Real, NonIrrat

object Rat {
  def apply(numer: BigInt, denom: BigInt): VNum =
    if (denom.sign == 0) {
      if (numer.sign == 0)
        throw ArithmeticException("Cannot divide 0 by 0")
      else if (numer.sign > 0)
        PosInf
      else NegInf
    } else if (numer.sign == 0) {
      Zero
    } else {
      val gcd = numer.gcd(denom)
      new Rat(numer / gcd, denom / gcd)
    }
}

case class Imag private[num] (factor: VNum) extends VNum, NonIrrat

sealed trait Irrat extends Real

/** A fraction with irrationals in the numerator and denominator, multiplied by
  * a non-irrational number `factor`
  */
case class IrratMulDiv private[num] (factor: VNum, numer: Seq[Irrat], denom: Seq[Irrat])
    extends Irrat

/** base raised to the power of pow. `pow` will always be a positive number */
case class Pow private[num] (base: Irrat, pow: Irrat) extends Irrat

/** The sum of a rational number, an imaginary number, and a finite number of
  * irrational numbers.
  */
case class Sum private (nonIrrat: VNum, irrats: Seq[Irrat]) extends Irrat

object Sum {
  def apply(nonIrrat: VNum, irrats: Seq[Irrat]): VNum = {
    ???
  }
}

/** An irrational number computed using a series whose terms' absolute values
  * are strictly decreasing.
  * @param approx
  *   A precomputed approximation of the number
  * @param intPart
  *   The part before the decimal point
  * @param digits
  *   All the digits after the decimal point
  * @param base
  *   The base that the digits are in
  */
case class IrratSeries private[num] (
    approx: Double,
    intPart: BigInt,
    digits: LazyList[Int],
    base: Int = 10
) extends VNum

object VNum {
  def int(i: BigInt) = Integer(i)

  def double(d: Double) = ???

  def frac(numer: BigInt, denom: BigInt) = Integer(numer) / Integer(denom)

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
