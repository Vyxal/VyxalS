package vyxal

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportTopLevel, JSExport}
import org.scalajs.dom
import org.scalajs.dom.{document, window}

@JSExportTopLevel("Vyxal")
object JSVyxal {
  @JSExport
  def execute(
      code: String,
      flags: String,
      inputs: String,
      outFn: js.Function1[String, Unit],
      warnFn: js.Function1[String, Unit],
      errFn: js.Function1[String, Unit]
  ): Unit = {
    given Backend with {
      override def print(out: String) = outFn(out)
      override def warn(warning: String) = warnFn(warning)
      override def err(error: String) = errFn(error)
    }

    Interpreter.execute(
      code,
      inputs.split("\n").toList,
      flags.map(_.toString).toList
    )
  }
}
