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
    val inputs: List[List[VAny]] = List(),
    private val printFn: String => Unit = print
) {
  private var stack = mut.ArrayBuffer(initStack*)
  private var printed = false

  def peek: VAny = stack(stack.size - 1)
  
  def pop(): VAny = stack.remove(stack.size - 1)

  def push(item: VAny): Unit = stack += item
  
  /** The last n items on the stack, in reverse order
    * e.g. Popping 3 of [1,2,3,4] results in [4,3,2]
    */
  def pop(n: Int): List[VAny] = List.fill(n)(stack.remove(stack.size - 1))

  def print(obj: Any) = {
    this.printed = true
    this.printFn(obj.toString)
  }

  def println(obj: Any) = this.print(obj.toString + "\n")

  def copy(
      stack: Seq[VAny] = this.stack.toSeq,
      vars: Map[String, VAny] = this.vars.toMap,
      inputs: List[List[VAny]] = this.inputs
  ) = new Context(stack, mut.Map(vars.toSeq*), inputs, this.printFn)

  override def toString = s"Context(stack=${stack.mkString("[", ", ", "]")})"
}

object Context {

  /** Helper to grab stack from implicit Context */
  def stack(using ctx: Context) = ctx.stack
}
