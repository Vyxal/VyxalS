package vyxal

import scala.scalajs.js
import scala.scalajs.js.annotation.*

@JSExportTopLevel("Vyxal")
object JSVyxal extends js.Object {
  def execute(
      code: String,
      inputs: js.Array[VAny],
      flags: js.Array[String]
  ): Unit = {
    Interpreter.execute(code, inputs.toList, flags.toList)
  }
}
