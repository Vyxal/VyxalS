package vyxal

import scala.collection.mutable.ArrayBuffer
import scala.reflect.Typeable

type VAny = VAtom | VList
type VAtom = VVal | VFun
type VVal = VNum | String
type VFun = Stack => Context ?=> Unit

// given Typeable[VVal] = (x: Any) => x match {
//   case vl: (x.type & VNum) => Some(vl)
//   case va: (x.type & String) => Some(va)
//   case _ => None
// }

given Typeable[VFun] = x => Option.when(x.isInstanceOf[Function1[?, ?]])(x.asInstanceOf[x.type & VFun])

given Typeable[VAtom] = (x: Any) => x match {
  case vl: (x.type & VVal) => Some(vl)
  case va: (x.type & VFun) => Some(va)
  case _ => None
}

given Typeable[VAny] = (x: Any) => x match {
  case vl: (x.type & VList) => Some(vl)
  case va: (x.type & VAtom) => Some(va)
  case _ => None
}

class Stack(initial: Seq[VAny] = Seq.empty) {

  /** Where the elements are actually stored
    */
  private val buf = initial.to(ArrayBuffer)

  def peek: VAny = buf(buf.length - 1)
  def pop(): VAny = buf.remove(buf.length - 1)
  def push(item: VAny): Unit = buf += item

  override def toString = buf.mkString("Stack(", ", ", ")")
}
