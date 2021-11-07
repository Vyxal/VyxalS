package vyxal

import collection.mutable.ArrayBuffer

type VAny = VAtom | VList
type VAtom = VVal | VFun
type VVal = VNum | String
type VFun = Stack => Context ?=> Unit

class Stack(initial: Seq[VAny] = Seq.empty) {

  /** Where the elements are actually stored
    */
  private val buf = initial.to(ArrayBuffer)

  def peek: VAny = buf(buf.length - 1)
  def pop(): VAny = buf.remove(buf.length - 1)
  def push(item: VAny): Unit = buf += item

  override def toString = buf.mkString("Stack(", ", ", ")")
}

object VAtom {
  def unapply(v: VAny): Option[VAtom] =
    Option.when(!v.isInstanceOf[VList])(v.asInstanceOf[VAtom])
}
