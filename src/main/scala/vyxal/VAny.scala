package vyxal

import collection.mutable.ArrayBuffer

type VAny = VVal | VFun | VList
type VVal = VNum | String
type VFun = Stack => Context ?=> Unit

class Stack(private val buf: ArrayBuffer[VAny]) {
  def peek: VAny = buf(buf.length - 1)
  def pop(): VAny = buf.remove(buf.length - 1)
  def push(item: VAny): Unit = buf += item
}
