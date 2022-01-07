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
    var printed: Boolean = false
)

object Context {
  /** Helper to grab stack from implicit Context */
  def stack(using ctx: Context) = ctx.stack
}
