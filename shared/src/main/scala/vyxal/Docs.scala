package vyxal

case class ElementDocs(
    name: String,
    desc: String,
    arity: Int,
    overloads: Map[String, String],
    vectorises: Boolean = false,
    modifiesStack: Boolean = false
)

object Docs {
  /** Documentation for every element */
  val elements: Map[String, ElementDocs] = Map(
    "+" -> ElementDocs(
      name = "Addition",
      desc = "Adds the top two items on the stack",
      arity = 2,
      overloads = Map(
        "num-num" -> "Add two integers",
      ),
      vectorises = true
    )
  )
}
