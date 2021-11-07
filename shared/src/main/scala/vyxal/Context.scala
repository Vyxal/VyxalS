package vyxal

import scala.collection.{mutable => mut}

/** @constructor
  *   Make a Context object for the current scope
  * @param vars
  *   The variables currently in scope, accessible by their names
  * @param inputs
  *   The inputs available in this scope
  */
case class Context(
    val vars: mut.Map[String, VAny] = mut.Map(),
    val inputs: List[List[VAny]] = List.empty
)
