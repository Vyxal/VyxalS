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
    var stack: Stack = Stack(),
    val vars: mut.Map[String, VAny] = mut.Map(),
    val inputs: List[List[VAny]] = List.empty,
    private val printFn: String => Unit = print
) {
  private var printed = false

  def print(obj: Any) = {
    this.printed = true
    this.printFn(obj.toString)
  }

  def println(obj: Any) = this.print(obj.toString + "\n")
}

object Context {

  /** Helper to grab stack from implicit Context */
  def stack(using ctx: Context) = ctx.stack
}
