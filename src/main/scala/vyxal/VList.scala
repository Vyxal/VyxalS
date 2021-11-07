package vyxal

import collection.mutable.ArrayBuffer

/**
 * A Vyxal list. It could represent a completely evaluated list, a finite list that is in the
 * process of being evaluated, or an infinite list.
 * @param initial Elements of this list that have already been generated. This should be a finite
 *                list.
 * @param rest An `Iterator` providing the rest of the list.
 */
class VList(initial: Seq[VAny], private val rest: Iterator[VAny]) extends Seq[VAny] {
  /**
   * An `ArrayBuffer` containing elements already generated by rest
   */
  private val generated = initial.to(ArrayBuffer)

  /**
   * Get another element from the iterator and add it to the list of generated elements.
   */
  private def getNext(): VAny = {
    val next = rest.next
    generated += next
    next
  }

  /**
   * Set the element at index `ind` to value `value`
   */
  def update(ind: Int, value: VAny): Unit = {

  }

  /**
   * Get the element at index `ind`
   */
  override def apply(ind: Int): VAny =
    if (ind < 0) {
      throw IndexOutOfBoundsException(s"Index $ind is negative")
    } else if (ind < generated.size) {
      initial(ind)
    } else {
      var i = generated.size
      while (i < ind && rest.hasNext) getNext()
      if (i == ind) generated(i)
      else throw IndexOutOfBoundsException(s"Index $ind greater than size $i")
    }
  
  override def iterator: Iterator[VAny] = generated.iterator ++ rest

  /**
   * Get the length of this `VList`. A word of caution: this fully evaluates
   * the list, meaning that it won't work with infinite iterators.
   */
  override def length: Int = {
    while (rest.hasNext) getNext()
    generated.size
  }
}