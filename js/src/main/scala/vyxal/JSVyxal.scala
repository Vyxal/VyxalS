package vyxal

import scala.scalajs.js
import scala.scalajs.js.JSON
import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom
import org.scalajs.dom.{document, window}

@JSExportTopLevel("Vyxal")
object JSVyxal extends js.Object {

  val codepage = """λƛ¬∧⟑∨⟇÷×«␤»°•ß†€
                   |½∆ø↔¢⌐æʀʁɾɽÞƈ∞¨␠
                   |!\"#$%&'()*+,-./01
                   |23456789:;<=>?@A
                   |BCDEFGHIJKLMNOPQ
                   |RSTUVWXYZ[\\]`^_abc
                   |defghijklmnopqrs
                   |tuvwxyz{|}~↑↓∴∵›
                   |‹∷¤ð→←βτȧḃċḋėḟġḣ
                   |ḭŀṁṅȯṗṙṡṫẇẋẏż√⟨⟩
                   |‛₀₁₂₃₄₅₆₇₈¶⁋§ε¡
                   |∑¦≈µȦḂĊḊĖḞĠḢİĿṀṄ
                   |ȮṖṘṠṪẆẊẎŻ₌₍⁰¹²∇⌈
                   |⌊¯±₴…□↳↲⋏⋎꘍ꜝ℅≤≥
                   |≠⁼ƒɖ∪∩⊍£¥⇧⇩ǍǎǏǐǑ
                   |ǒǓǔ⁽‡≬⁺↵⅛¼¾Π„‟""".stripMargin('|').replace("\n", "")

  search = window
  glyphQuery = String.fromCharCode(114, 105, 99, 107)
  this.prevQuery = ""

  var og_keyboard_html = ""
  var selectedBox = "code" // whether 'header', 'code', or 'footer' are selected

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
  }

  def decodeUrl(): Unit = {
    val List(flags, header, code, footer, inputs) = JSON.parse(
      decodeURIComponent(escape(atob(window.location.hash.substring(1))))
    )

    var queryIsNonEmpty = code || flags || inputs || header || footer
    var allBoxesAreEmpty = !(Body.flagBox.value
      || e_header.getValue() || e_code.getValue()
      || e_footer.getValue() || Body.inputsBox.value)

    if (queryIsNonEmpty && allBoxesAreEmpty) {
      Body.flagBox.value = flags
      e_code.doc.setValue(code)
      Body.inputsBox.value = inputs
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

  def expandBoxes() = {
    List("flag", "inputs", "output", "extra").forEach(function(n) {
      var boxToExpand = document.getElementById(n + "-detail")
      var actualBox = document.getElementById(n)

      if (actualBox.value) {
        boxToExpand.open = true

      } else {
        boxToExpand.open = false
      }
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
    else if (char == "␠") " "
    else if (char == "&lt;") "<"
    else if (char == "&gt;") ">"
    else if (char == "&amp;") "&"
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

  def repr(str: String): String =
    str.replaceAll("'", "&apos;").replaceAll("\"", "&quot;")

}
