package vyxal

import Helpers.*
import Helpers.given

import scala.collection.{mutable => mut}

object Builtins {

  /** Get an element by its name
    */
  def getElement(name: String): DirectFn = Impls.elements(name)

  private object Impls {

    /** Maps element names to their implementations. This is built up as
      * implementations are defined.
      */
    val elements = mut.Map[String, DirectFn]()

    def addNilad(name: String)(impl: () => Context ?=> VAny) = {
      elements += name -> DirectFn(() => ctx ?=> ctx.push(impl()), 1)
      impl
    }

    def addMonad(name: String)(impl: Monad): Monad = {
      elements += name -> DirectFn(
        { () => ctx ?=>
          ctx.push(impl(ctx.pop()))
        },
        1
      )
      impl
    }

    def addMonadVect(name: String)(impl: SimpleMonad) =
      addMonad(name)(vect1(impl))

    def addDyad(name: String)(impl: Dyad): Dyad = {
      elements += name -> DirectFn(
        { () => ctx ?=>
          ctx.push(impl(ctx.pop(), ctx.pop()))
        },
        2
      )
      impl
    }

    def addDyadVect(name: String)(impl: SimpleDyad) = addDyad(name)(vect2(impl))

    def addTriad(name: String)(impl: Triad): Triad = {
      elements += name -> DirectFn(
        { () => ctx ?=>
          ctx.push(
            impl(ctx.pop(), ctx.pop(), ctx.pop())
          )
        },
        3
      )
      impl
    }

    def addTriadVect(name: String)(impl: SimpleTriad) =
      addTriad(name)(vect3(impl))

    /** Add an element that works directly on the entire stack */
    def addDirect(name: String)(impl: Context ?=> Unit): Unit =
      elements += name -> DirectFn(() => impl, -1)

    addDirect(",") { ctx ?=>
      Helpers.vyPrint(ctx.pop())
      Helpers.vyPrint("\n")
    }

    val add = addDyad("+")(vect2 {
      case (n1: VNum, n2: VNum) => n1 + n2
      case (s: String, n: VNum) => s + n
      case (n: VNum, s: String) => n.toString + s
      case (s1: String, s2: String) => s1 + s2
      case _ => throw VyOverloadError("Functions can't be added")
    })

    val halve = addMonad("½")(vect1 {
      case n: VNum => n / 2
      case s: String =>
        val half = (s.size + 1) / 2
        VList.of(s.substring(0, half), s.substring(half + 1))
      case f =>
        throw VyOverloadError("Sorry, you can't halve functions")
    })

    val land = addDyad("∧")(_.toBool && _.toBool)

    val lnot = addMonad("¬")(!_.toBool)

    val lor = addDyad("∨")(_.toBool || _.toBool)

    val mul = addDyad("*")(vect2 {
      case (n1: VNum, n2: VNum) => n1 * n2
      case (n: VNum, s: String) => s * n.toInt
      case (s: String, n: VNum) => s * n.toInt
      case _ => ???
    })

    val subtract = addDyad("-")(vect2 {
      case (n1: VNum, n2: VNum) => n1 - n2
      case (s: String, n: VNum) => s + "-" * n.toInt
      case (n: VNum, s: String) => "-" * n.toInt + s
      case (s1: String, s2: String) => s1.replace(s2, "")
      case _ => throw VyOverloadError("Functions can't be subtracted")
    })

    val sum = addMonad("∑") {
      case n: VNum => ???
      case s: String => s
      case l: VList => l.foldl(0)((a, b) => add.norm.apply(a, b))
      case f =>
        throw VyOverloadError(
          "What's the sum of a function even supposed to be?"
        )
    }

    val exec = addMonad("†") { case x =>
      throw NotImplementedError(
        s"† is still unimplemented (tried executing on $x)"
      )
    }
  }
}
