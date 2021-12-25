package vyxal

import Helpers.*
import Helpers.given

import scala.collection.{mutable => mut}

object Builtins {

  /** Maps element names to their implementations. This is built up as
    * implementations are defined.
    */
  private val _elements = mut.Map[String, Stack => Context ?=> Unit]()

  /** Get an element by its name
    */
  def element(name: String) = _elements(name)

  def addMonad(name: String)(impl: Monad): Monad = {
    _elements += name -> { stack => stack.push(impl(stack.pop())) }
    impl
  }

  def addMonadVect(name: String)(impl: SimpleMonad) =
    addMonad(name)(vect1(impl))

  def addDyad(name: String)(impl: Dyad): Dyad = {
    _elements += name -> { stack => stack.push(impl(stack.pop(), stack.pop())) }
    impl
  }

  def addDyadVect(name: String)(impl: SimpleDyad) = addDyad(name)(vect2(impl))

  def addTriad(name: String)(impl: Triad): Triad = {
    _elements += name -> (stack => impl(stack.pop(), stack.pop(), stack.pop()))
    impl
  }

  def addTriadVect(name: String)(impl: SimpleTriad) =
    addTriad(name)(vect3(impl))

  val add = addDyad("+")(vect2 {
    case (n1: VNum, n2: VNum)     => n1 + n2
    case (s: String, n: VNum)     => s + n
    case (n: VNum, s: String)     => n.toString + s
    case (s1: String, s2: String) => s1 + s2
    case _ => throw IllegalArgumentException("Functions can't be added")
  })

  val land = addDyad("∧")(_.toBool && _.toBool)

  val lnot = addMonad("¬")(!_.toBool)

  val lor = addDyad("∨")(_.toBool || _.toBool)

  val subtract = addDyad("-")(vect2 {
    case (n1: VNum, n2: VNum)     => n1 - n2
    case (s: String, n: VNum)     => s + "-" * n.toInt
    case (n: VNum, s: String)     => "-" * n.toInt + s
    case (s1: String, s2: String) => s1.replace(s2, "")
    case _ => throw IllegalArgumentException("Functions can't be subtracted")
  })

  val sum = addMonad("∑")(vect1 {
    case n: VNum   => ???
    case s: String => s
    case l: VList  => l.foldl(0)((a, b) => add.norm.apply(a, b))
    case f =>
      throw IllegalArgumentException(
        "What's the sum of a function even supposed to be?"
      )
  })
}
