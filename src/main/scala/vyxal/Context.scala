package vyxal

import scala.collection.{mutable => mut}

case class Context(
  val vars: mut.Map[String, VAny]
)