package vyxal

import collection.mutable.ArrayBuffer

/** A Vyxal list. It could represent a completely evaluated list, a finite list
  * that is in the process of being evaluated, or an infinite list.
  * @param lst
  *   The Scala list actually holdings this VList's elements
  */
class VList(val lst: Seq[VAny]) extends Seq[VAny] {
  def foldl(start: VAny)(op: (VAny, VAny) => VAny): VAny =
    this.fold(start)(op)

  def output()(using ctx: Context): Unit = {
    ctx.print("⟨")
    var first = true
    for (elem <- this) {
      if (first) {
        first = false
      } else {
        print(" | ")
      }
      Helpers.vyPrint(elem)
    }
    ctx.print("⟩")
  }

  def vmap(f: Monad)(using Context): VList = VList(lst.map(f(_)))

  /** Zip two VLists together with a function. If one is longer than the other,
    * keep the longer one's elements as-is.
    */
  def zipWith(other: VList)(f: (VAny, VAny) => VAny): VList =
    VList(
      (lst: Seq[VAny | EmptyTuple])
        .zipAll(other.lst: Seq[VAny | EmptyTuple], EmptyTuple, EmptyTuple)
        .map {
          case (elem: VAny, EmptyTuple) => VList.of(elem)
          case (EmptyTuple, elem: VAny) => VList.of(elem)
          case (elem1: VAny, elem2: VAny) => VList.of(elem1, elem2)
        }
    )

  /** Set the element at index `ind` to value `value`
    */
  def update(ind: Int, value: VAny): Unit = {}

  /** Get the element at index `ind`
    */
  override def apply(ind: Int): VAny = lst(ind)

  override def iterator: Iterator[VAny] = lst.iterator

  /** Get the length of this `VList`. A word of caution: this fully evaluates
    * the list, meaning that it won't work with infinite lists.
    */
  override def length: Int = lst.length
}

object VList {

  /** Zip multiple VLists together with a function.
    */
  def zipMulti(lists: VList*)(f: Seq[VAny] => VAny): VList = {
    // val its = lists.map(_.iterator)

    // VList(
    //   Seq.empty,
    //   new scala.collection.Iterator[VAny] {
    //     def hasNext: Boolean = its.exists(_.hasNext)
    //     def next: VAny = f(its.collect { case it if it.hasNext => it.next })
    //   }
    // )
    ???
  }

  def of(elems: VAny*) = VList(elems)

  /** This lets us pattern match on `VList`s, silly as the implementation may
    * be.
    */
  def unapplySeq(vlist: VList): Seq[VAny] = vlist.lst
}
