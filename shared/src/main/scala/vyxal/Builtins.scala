package vyxal

import Helpers.*
import Helpers.given

import scala.collection.{mutable => mut}

object Builtins {

  /** Maps element names to their implementations. This is built up as
    * implementations are defined.
    */
  private val _elements = mut.Map[String, VFun]()

  /** Get an element by its name
    */
  def element(name: String) = _elements(name)

  def addMonad(name: String)(impl: Monad): Monad = {
    _elements += name -> { stack => stack.push(impl(stack.pop())) }
    impl
  }

  def addMonadVect(name: String)(impl: SimpleMonad): Monad = {
    val res = impl.vectorised
    _elements += name -> { stack => stack.push(res(stack.pop())) }
    res
  }

  def addDyad(name: String)(impl: Dyad): Dyad = {
    _elements += name -> { stack => stack.push(impl(stack.pop(), stack.pop())) }
    impl
  }

  def addDyadVect(name: String)(impl: SimpleDyad): Dyad = {
    val res = impl.vectorised
    _elements += name -> (stack => res(stack.pop(), stack.pop()))
    res
  }

  def addTriad(name: String)(impl: Triad): Triad = {
    _elements += name -> (stack => impl(stack.pop(), stack.pop(), stack.pop()))
    impl
  }

  def addTriadVect(name: String)(impl: SimpleTriad): Triad = {
    val res = impl.vectorised
    _elements += name -> (stack => res(stack.pop(), stack.pop(), stack.pop()))
    res
  }

  val add = addDyadVect("+") {
    case (n1: VNum, n2: VNum)     => n1 + n2
    case (s1: String, n2: VNum)   => s1 + n2
    case (n1: VNum, s2: String)   => n1.toString + s2
    case (s1: String, s2: String) => s1 + s2
    case _ => throw IllegalArgumentException("Functions can't be added")
  }

  val sum = addMonad("∑") {
    case n: VNum   => ???
    case s: String => s
    case l: VList  => l.foldl(0)((a, b) => add.norm.apply(a, b))
    case f =>
      throw IllegalArgumentException(
        "What's the sum of a function even supposed to be?"
      )
  }
}
