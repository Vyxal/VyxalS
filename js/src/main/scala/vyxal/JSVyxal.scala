package vyxal

import scala.scalajs.js
import scala.scalajs.js.annotation.*

@JSExportTopLevel("Vyxal")
object JSVyxal extends js.Object {
  def execute(
      code: String,
      inputs: js.Array[VAny],
      flags: js.Array[String],
      outputFn: js.Function1[String, Unit],
      warnFn: js.Function1[String, Unit],
      errFn: js.Function1[String, Unit]
  ): Unit = {
    given Backend with {
      override def print(s: String) = outputFn(s)
      override def warn(s: String) = warnFn(s)
      override def err(s: String) = errFn(s)
    }
    Interpreter.execute(code, inputs.toList, flags.toList)
  }
}
