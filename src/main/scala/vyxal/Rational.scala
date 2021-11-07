package vyxal

case class Rational private(val numer: BigInt, val denom: BigInt) {
  def unary_- : Rational = Rational(-numer, denom)
}

object Rational {
  def apply(numer: BigInt, denom: BigInt): Rational = new Rational(numer, denom)
}

type VNum = BigInt | Rational

extension (self: Rational) {
  def +(that: VNum): Rational = that match {
    case num: BigInt => Rational(self.numer + num, self.denom)
    case Rational(num, den) => Rational(self.numer * den + num * self.denom, self.denom * den)
  }

  def -(that: VNum): Rational = that match {
    case num: BigInt => Rational(self.numer - num, self.denom)
    case Rational(num, den) => Rational(self.numer * den + num * self.denom, self.denom * den)
  }

  def *(that: VNum): Rational = that match {
    case num: BigInt => Rational(self.numer * num, self.denom)
    case Rational(num, den) => Rational(self.numer * num, self.denom * den)
  }

  def /(that: VNum): Rational = that match {
    case num: BigInt => Rational(self.numer, self.denom * num)
    case Rational(num, den) => Rational(self.numer * den, self.denom * num)
  }
}
