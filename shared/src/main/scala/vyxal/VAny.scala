package vyxal

import scala.collection.mutable.ArrayBuffer
import scala.reflect.Typeable

import spire.math.Number

type VAny = VAtom | VList
type VAtom = VVal | VFun
type VVal = VNum | String
type VNum = Number

enum VFun(arity: Int) {
  case Lam(lam: Lambda, ctx: Context) extends VFun(1)
  case FnRef(fnDef: FnDef, ctx: Context) extends VFun(fnDef.arity)
  case ElemRef(elem: String, arity: Int) extends VFun(arity)

  /** Function created by applying a modifier */
  case ModRes(mod: Modified) extends VFun(mod.arity)
}

given Typeable[VAtom] = (x: Any) =>
  x match {
    case vl: (x.type & VVal) => Some(vl)
    case va: (x.type & VFun) => Some(va)
    case _ => None
  }

given Typeable[VAny] = (x: Any) =>
  x match {
    case vl: (x.type & VList) => Some(vl)
    case va: (x.type & VAtom) => Some(va)
    case _ => None
  }

extension (i: Int) def vnum: VNum = Number(i)
extension (b: BigInt) def vnum: VNum = Number(b)
extension (d: Double) def vnum: VNum = Number(d)
