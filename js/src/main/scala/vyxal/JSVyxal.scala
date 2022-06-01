package vyxal

import scala.scalajs.js
import scala.scalajs.js.JSON
import scala.scalajs.js.annotation.*
import org.scalajs.dom
import org.scalajs.dom.{document, window}

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
    // Get the corresponding codemirror textarea for any of "code", "header", and "footer"
    def getCodeMirrorTextArea(boxId: String): dom.Element = {
      val top = document
        .getElementById(boxId)
        .parentNode
        .parentNode
        .asInstanceOf[dom.Element]
      top
        .querySelectorAll("div")
        .flatMap(_.querySelectorAll(":not[class]"))
        .flatMap(_.childNodes)
        .head
        .asInstanceOf[dom.Element]
    }

    def resize(elem: dom.Element): Unit = {
      val dummy = document.querySelector("#dummy")
      dummy.style.fontFamily = getComputedStyle(
        document.querySelector(".CodeMirror.cm-s-default")
      ).fontFamily
      dummy.style.fontSize = "15px"
      dummy.style.lineHeight = "24px"
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

    val mode = js.Dictionary(
      "mode" -> "vyxal",
      "lineWrapping" -> true,
      "autofocus" -> true
    )

    for (boxId <- List("header", "code", "footer")) {
      println(boxId)
      globalThis(s"e_$boxId") =
        CodeMirror.fromTextArea(document.querySelector("#" + boxId), mode)
      globalThis(s"e_$boxId").on(
        "change",
        cm => {
          resize(globalThis["e_" + boxId])
          globalThis["e_" + boxId].value = cm.getValue()
        }
      )
      resize(globalThis["e_" + boxId])

      var box = getCodeMirrorTextArea(boxId)
      if (box) {
        val capturedId = boxId
        box.addEventListener("focusin", event => selectedBox = capturedId)
      }
    }
  }

  def decodeUrl(): Unit = {
    val List(flags, header, code, footer, inputs) = JSON.parse(
      decodeURIComponent(escape(atob(window.location.hash.substring(1))))
    )

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
    byteBox.innerText =
      s"Code: $len byte${if (len == 1) "" else "s"} ${if (sbcsOnly) ""
      else " (UTF-8)"}"
  }

  def resizeCodeBox(id: String) = {
    // Resize the code box with the given id
    val element = document.getElementById(id);
    element.style.height = ""
    element.style.height = element.scrollHeight + 4 + "px"
  }

  def expandBoxes() = {
    List("flag", "inputs", "output", "extra").forEach(function(n) {
      var boxToExpand = document.getElementById(n + "-detail")
      var actualBox = document.getElementById(n)

      if (actualBox.value) {
        boxToExpand.open = true

      } else {
        boxToExpand.open = false
      }

      Vyxal.resizeCodeBox(n)

    })

    if (e_header.getValue()) {
      document.getElementById("header-detail").open = true
      e_header.refresh()
    }

    if (e_footer.getValue()) {
      document.getElementById("footer-detail").open = true
      e_footer.refresh()
    }
  }

  def replaceHTMLChar(char: String) = {
    if (char == "␤") "\n"
    else if (char === "␠") " "
    else if (char === "&lt;") "<"
    else if (char === "&gt;") ">"
    else if (char === "&amp;") "&"
    else char
  }

  def copyToClipboard(arg: String) = {
    val el = document.getElementById(arg)
    // navigator.clipboard.writeText(el)
    el.select()
    document.execCommand("copy")
  }

  def generateURL() = {
    var flags = document.getElementById("flag").value
    var code = e_code.doc.getValue()
    var inputs = document.getElementById("inputs").value
    var header = e_header.doc.getValue()
    var footer = e_footer.doc.getValue()

    var url = List(flags, header, code, footer, inputs);
    val encoded = btoa(unescape(encodeURIComponent(JSON.stringify(url))))
    return location.origin + "/#" + encoded
  }

  def shareOptions(shareType: String) = {
    var code = e_code.doc.getValue()
    var url = generateURL()
    var flags = document.getElementById("flag").value
    var flag_appendage = ","
    if (flags) {
      flag_appendage = " `" + flags + "`,"
    }
    var utfable = code.forall(x => s"$codepage \n".contains(x))
    var len = if (utfable) code.length else code.getBytes().size
    val output = sharetype match {
      case "permalink" => url
      case "cmc" =>
        s"[Vyxal, ${len} byte${"s".repeat(code.length != 1)}${if (utfable) ""
        else " (UTF-8)"}]($url)"
      case "post-template" =>
        s"""# [Vyxal](https://github.com/Vyxal/Vyxal)$flag_appendage $len byte${"s"
          .repeat(len != 1)}${if (utfable) "" else " (UTF-8)"}
```
$code
```
[Try it Online!](${url})"""
      case "markdown" => s"[Try it Online!]($url)"
      case _ => ""
    }
    var outputBox = document.getElementById("output")
    outputBox.value = output
    copyToClipboard("output")
    Vyxal.resizeCodeBox("output")
    expandBoxes()
  }

  def repr(str: String): String = str.replaceAll("'", "&apos;").replaceAll("\"", "&quot;")

}
