package vyxal.num

import scala.collection.immutable.LazyList

import vyxal.VList

sealed trait VNum {
  final def unary_- : VNum = this match {
    case Zero => Zero
    case PosInf => PosInf
    case NegInf => NegInf
    case Rat(num, den) => Rat(-num, den)
    case Imag(n) => Imag(-n)
    case Pow(base, pow) =>
      // todo check if numerator of pow is odd
      Frac(Seq(base), Seq(-1))
    case Sum(terms) => Sum(terms.map(-1 * _))
    case Frac(nums, dens) =>
      if (nums.nonEmpty) Frac(-nums.head +: nums, dens)
      else Frac(nums, -dens.head +: dens)
    case IrratSeries(approx, terms) => IrratSeries(-approx, terms.map(- _))
  }

  final def +(that: VNum): VNum = (this, that) match {
    case (Zero, _) => that
    case (_, Zero) => this
    case (inf1 @ (PosInf | NegInf), inf2 @ (PosInf | NegInf)) =>
      if (inf1 != inf2)
        throw ArithmeticException("Cannot add infinities of opposite sign")
      else inf1
    case (inf @ (PosInf | NegInf), _) => inf
    case (_, inf @ (PosInf | NegInf)) => inf
    case (Rat(num1, den1), Rat(num2, den2)) =>
      Rat(num1 * den2 + num2 * den1, den1 * den2)
    case (s: Sum, x) => addToSum(s, x)
    case (x, s: Sum) => addToSum(s, x)
    case (s1: IrratSeries, s2: IrratSeries) => ???
    case (x, IrratSeries(approx, terms)) => IrratSeries(approx + x.toDouble, terms.map(_ + x))
    case (IrratSeries(approx, terms), x) => IrratSeries(approx + x.toDouble, terms.map(_ + x))
    case (Frac(num1, den1), Frac(num2, den2)) => ???
  }

  private def addToSum(sum: Sum, x: VNum): VNum = {
    ???
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
    case (Sum(xs), Sum(ys)) => Sum(for (x <- xs; y <- ys) yield x * y)
    case (Sum(terms), n) => Sum(terms.map(_ * n))
    case (n, Sum(terms)) => Sum(terms.map(_ * n))
    case (Rat(num1, den1), Rat(num2, den2)) =>
      Rat(num1 * num2, den1 * den2)
    case (Imag(n1), Imag(n2)) => -(n1 * n2)
    case (n1, Imag(n2)) => Imag(n2 * n2)
    case (Imag(n1), n2) => -(n1 * n2)
    case (Frac(num1, den1), Frac(num2, den2)) => Frac(num1 ++ num2, den1 ++ den2)
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
    case Rat(numer, denom) => ???
    case _: Imag => throw ArithmeticException(s"Cannot convert imaginary number ($this) to double")
    case ir: Irrat => ir.toDouble
  }

  final def toLong: Long = this.toDouble.toLong

  final def toInt: Int = this.toDouble.toInt

  final def isZero: Boolean = Zero == this

  final def isNeg: Boolean = this < 0

  final def isPos: Boolean = this > 0

  /** Whether this number is either positive or negative infinity */
  def isInf: Boolean = PosInf == this || NegInf == this
  def isInt: Boolean = this match {
    case r: Rat => r.denom == 1
    case _ => false
  }
  def isRat: Boolean = this == Zero || this.isInstanceOf[Rat]
  def isIrrat: Boolean = this.isInstanceOf[Irrat]
  def isReal: Boolean = this.isRat || this.isIrrat

  /** 1 if positive, 0 if zero, -1 if negative */
  def sign: Int = this match {
    case Zero => 0
    case PosInf => 1
    case NegInf => -1
    case Rat(num, den) => num.sign.toInt * den.sign.toInt
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

case object Zero extends VNum

/** Positive infinity */
case object PosInf extends VNum

/** Negative infinity */
case object NegInf extends VNum

case class Rat private (numer: BigInt, denom: BigInt) extends VNum

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

case class Imag private[num] (factor: VNum) extends VNum

sealed trait Irrat extends VNum

/** A number divided by another
  */
case class Frac private (numer: Seq[VNum], denom: Seq[VNum]) extends VNum

object Frac {
  def apply(numer: Seq[VNum], denom: Seq[VNum]): VNum = {
    ???
  }
}

/** [[Pow.base]] raised to the power of [[Pow.pow]]. `pow` must be positive, `base` must be nonnegative */
case class Pow private[num] (base: Irrat, pow: Irrat) extends Irrat

/** The sum of a rational number, an imaginary number, and a finite number of
  * irrational numbers.
  */
case class Sum private[num] (terms: Seq[VNum]) extends VNum

object Sum {
  // def apply(nonIrrat: VNum, irrats: Seq[Irrat]): VNum = {
  //   ???
  // }
}

/** An irrational number computed using a series whose terms' absolute values
  * are strictly decreasing.
  * @param approx
  *   A precomputed approximation of the number
  * @param terms
  *   Infinite list of terms whose sum equals the number
  */
case class IrratSeries private[num] (
    approx: Double,
    terms: LazyList[VNum]
) extends Irrat

object VNum {
  def int(i: BigInt) = Rat(i, 1)

  def double(d: Double) = ???

  def frac(numer: BigInt, denom: BigInt) = Rat(numer, denom)

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
