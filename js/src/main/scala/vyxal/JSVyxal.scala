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

  def initCodeMirror(): Unit = {
    //Get the corresponding codemirror textarea for any of 'code', 'header', and 'footer'
    function getCodeMirrorTextArea(boxId) {
        return $('#' + boxId).parent().children('div').children().not('[class]').children()[0]
    }

    function resize(elem) {
        var dummy = document.querySelector("#dummy")
        dummy.style.fontFamily = getComputedStyle(document.querySelector('.CodeMirror.cm-s-default')).fontFamily
        dummy.style.fontSize = '15px'
        dummy.style.lineHeight = '24px'
        dummy.value = elem.doc.getValue()
        elem.setSize(
            null,
            (elem.lineCount() * 22) + 24
        )
        elem.refresh();
        dummy.value = ""

        // Make sure e_code is not null
        if ("e_code" in globalThis) {
            updateCount()
        }
    }

    let mode = {
        mode: 'vyxal',
        lineWrapping: true,
        autofocus: true,
    }

    for (const boxId of ['header', 'code', 'footer']) {
        console.log(boxId)
        globalThis['e_' + boxId] = CodeMirror.fromTextArea(document.querySelector('#' + boxId), mode)
        globalThis['e_' + boxId].on('change', cm => {
            resize(globalThis['e_' + boxId])
            globalThis['e_' + boxId].value = cm.getValue()
        })
        resize(globalThis['e_' + boxId])

        var box = getCodeMirrorTextArea(boxId)
        if (box) {
            const capturedId = boxId
            box.addEventListener('focusin', event => selectedBox = capturedId)
        }
    }
  }

  def decodeUrl(): Unit = {
    val [flags, header, code, footer, inputs] = decode(window.location.hash.substring(1));

    var flag_box = document.getElementById("flag")
    var inputs_box = document.getElementById("inputs")

    var queryIsNonEmpty = code || flags || inputs || header || footer
    var allBoxesAreEmpty = !(flag_box.value
        || e_header.getValue() || e_code.getValue()
        || e_footer.getValue() || inputs_box.value)

    if (queryIsNonEmpty && allBoxesAreEmpty) {
        flag_box.value = flags
        e_code.doc.setValue(code)
        inputs_box.value = inputs
        e_header.doc.setValue(header)
        e_footer.doc.setValue(footer)
        e_header.refresh()
        e_footer.refresh()
        run_button.click()
    } else {
        expandBoxes()
    }
  }

  def updateCount(): Unit = {
    val byteBox = document.getElementById("code-count")

    val code = e_code.getValue()
    val sbcsOnly = code.forall(c => s"$codepage \n".contains(c))
    val len = if (sbcsOnly) code.length else code.getBytes().length
    byteBox.innerText = s"Code: $len byte${if (len == 1) "" else "s"} ${if (sbcsOnly) "" else " (UTF-8)"}"
  }
}
