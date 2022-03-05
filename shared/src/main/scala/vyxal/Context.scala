package vyxal

import scala.collection.{mutable => mut}

/** @constructor
  *   Make a Context object for the current scope
  * @param vars
  *   The variables currently in scope, accessible by their names
  * @param inputs
  *   The inputs available in this scope
  */
class Context(
    initStack: Seq[VAny] = Seq(),
    val vars: mut.Map[String, VAny] = mut.Map(),
    val inputs: List[List[VAny]] = List()
)(using backend: Backend) {
  private var stack = mut.ArrayBuffer(initStack*)
  private var printed = false

  def peek: VAny = stack(stack.size - 1)

  def pop(): VAny = if (stack.isEmpty) VNum(0) else stack.remove(stack.size - 1)

  def push(item: VAny): Unit = stack += item

  /** The last n items on the stack, in reverse order e.g. Popping 3 of
    * [1,2,3,4] results in [4,3,2]
    */
  def pop(n: Int): List[VAny] = List.fill(n)(stack.remove(stack.size - 1))

  def isStackEmpty: Boolean = stack.isEmpty

  def print(obj: Any) = {
    this.printed = true
    this.backend.print(obj.toString)
  }

  def println(obj: Any) = {
    this.print(obj)
    this.print("\n")
  }

  def copy(
      stack: Seq[VAny] = this.stack.toSeq,
      vars: Map[String, VAny] = this.vars.toMap,
      inputs: List[List[VAny]] = this.inputs
  ) = new Context(stack, mut.Map(vars.toSeq*), inputs)

  override def toString = s"Context(stack=${stack.mkString("[", ", ", "]")})"
}

object Context {

  /** Helper to grab stack from implicit Context */
  def stack(using ctx: Context) = ctx.stack
}
