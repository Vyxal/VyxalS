package vyxal

import org.scalajs.dom
import scalatags.JsDom.all.*

/** Wraps a box in a <details> element so it can be expanded/collapsed. The only
  * real reason for this is to group the details and codeboxes together.
  */
class Collapsible[+B <: dom.Element](
    label: String,
    val contents: B,
    extraContents: scalatags.JsDom.Modifier*
) {
  val details = tag("details")(
    (Seq[scalatags.JsDom.Modifier](
      id := contents.id + "-detail",
      tag("summary")(id := contents.id + "-label", label)
    ) ++
      extraContents
      :+ contents)*
  ).render

  def isOpen: Boolean = details.hasAttribute("open")

  def expand(): Unit = {
    if (!isOpen) {
      details.setAttribute("open", "open")
    }
  }

  def collapse(): Unit = {
    details.removeAttribute("open")
  }

  def toggle(): Unit = {
    if (isOpen) {
      collapse()
    } else {
      expand()
    }
  }
}
