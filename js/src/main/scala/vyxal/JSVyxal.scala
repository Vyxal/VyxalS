package vyxal

import scala.scalajs.js
import scala.scalajs.js.JSON
import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom
import org.scalajs.dom.{document, window}
import scalatags.JsDom.all.*
import scalatags.JsDom.TypedTag

@JSExportTopLevel("Vyxal")
object JSVyxal extends js.Object {
  private val codepage = """λƛ¬∧⟑∨⟇÷×«␤»°•ß†€
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

  private var prevQuery = ""
  private var selectedBox =
    "code" // whether 'header', 'code', or 'footer' are selected

  private given Backend with {
    override def print(out: String) = {
      outputBox.contents.value += out
    }
    override def warn(warn: String) = {
      errorBox.contents.value += warn
    }
    override def err(err: String) = {
      errorBox.contents.value += err
    }
  }

  type HasValue = {
    def value: String
    def value_=(v: String): Unit
  }

  def run() = {
    runButton.blur()
    println("Running!")
    if (!runButton.innerHTML.contains("fa-spin")) {
      runButton.innerHTML =
        """<svg class="fa-spin" style="width:24px;height:24px" viewBox="0 0 24 24">
                    <path fill="currentColor" d="M12,4V2A10,10 0 0,0 2,12H4A8,8 0 0,1 12,4Z"/>
                </svg>""";
      outputBox.contents.value = "";
      errorBox.contents.value = "";

      val allCode =
        headerBox.contents.value + codeBox.contents.value + footerBox.contents.value

      Interpreter.execute(
        allCode,
        inputsBox.contents.value.split("\n").toList,
        flags.map(_.toString).toList
      )

      JSVyxal.expandBoxes()
    } else {
      // todo kill if already running
    }
    runButton.innerHTML = """<i class="fas fa-play-circle"/>""";
  }

  def clear(): Unit = {
    flagBox.contents.value = ""
    headerBox.contents.value = ""
    codeBox.contents.value = ""
    footerBox.contents.value = ""
    inputsBox.contents.value = ""
    outputBox.contents.value = ""
    updateCount()
    expandBoxes()
  }

  def decodeUrl(): Unit = {
    // val List(flags, header, code, footer, inputs) = JSON.parse(
    //   decodeURIComponent(escape(atob(window.location.hash.substring(1))))
    // )

    // val queryIsNonEmpty = code || flags || inputs || header || footer
    // val allBoxesAreEmpty = !(flagBox.value
    //   || e_header.getValue() || e_code.getValue()
    //   || e_footer.getValue() || inputsBox.value)

    // if (queryIsNonEmpty && allBoxesAreEmpty) {
    //   flagBox.value = flags
    //   e_code.doc.setValue(code)
    //   inputsBox.value = inputs
    //   e_header.doc.setValue(header)
    //   e_footer.doc.setValue(footer)
    //   e_header.refresh()
    //   e_footer.refresh()
    //   run_button.click()
    // } else {
    //   expandBoxes()
    // }
  }

  def updateCount(): Unit = {
    // val byteBox = document.getElementById("code-count")

    // val code = codeBox.contents.value
    // val sbcsOnly = code.forall(s"$codepage \n".contains)
    // val len = if (sbcsOnly) code.length else code.getBytes().length
    // byteBox.innerText =
    //   s"Code: $len byte${if (len == 1) "" else "s"} ${if (sbcsOnly) ""
    //   else " (UTF-8)"}"
  }

  def expandBoxes() = {
    flagBox.expand()
    for (
      collapsible <- List(
        flagBox,
        inputsBox,
        outputBox,
        errorBox
      )
    ) {
      if (collapsible.contents.value.nonEmpty) {
        collapsible.expand()
      } else {
        collapsible.collapse()
      }
    }

    if (header.nonEmpty) {
      headerBox.expand()
      // e_header.refresh()
    }

    if (footer.nonEmpty) {
      footerBox.expand()
      // e_footer.refresh()
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
    // el.select()
    document.execCommand("copy")
  }

  def generateURL(): String = {
    ???
    // val flags = document.getElementById("flag").value
    // val code = e_code.doc.getValue()
    // val inputs = document.getElementById("inputs").value
    // val header = e_header.doc.getValue()
    // val footer = e_footer.doc.getValue()

    // val url = List(flags, header, code, footer, inputs);
    // val encoded = btoa(unescape(encodeURIComponent(JSON.stringify(url))))
    // return location.origin + "/#" + encoded
  }

  enum ShareType {
    case Permalink, Cmc, PostTemplate, Markdown
  }

  def shareOptions(shareType: ShareType) = {
    val code = codeBox.contents.value
    val url = generateURL()
    val flagAppendage = if (flags.isEmpty) "" else s" `$flags`"
    val utfable = code.forall(x => s"$codepage \n".contains(x))
    val len = if (utfable) code.length else code.getBytes().size
    val byteAppendage = if (len == 1) "1 byte" else s"$len bytes"
    val encAppendage = if (utfable) "" else " (UTF-8)"
    val output = shareType match {
      case ShareType.Permalink => url
      case ShareType.Cmc =>
        s"[Vyxal, ($byteAppendage)$encAppendage]($url)"
      case ShareType.PostTemplate =>
        s"""# [Vyxal](https://github.com/Vyxal/Vyxal)$flagAppendage, ($byteAppendage)$encAppendage"
            |```
            |$code
            |```
            |[Try it Online!](${url})""".stripMargin
      case ShareType.Markdown => s"[Try it Online!]($url)"
    }

    outputBox.contents.value = output
    copyToClipboard("output")
    JSVyxal.resizeCodeBox(outputBox.contents)
    expandBoxes()
  }

  def repr(str: String): String =
    str.replaceAll("'", "&apos;").replaceAll("\"", "&quot;")

  def resizeCodeBox(box: dom.html.Element) = {
    ???
  }

  def initCodeMirror(): Unit = {
    // todo implement
  }

  def flags = flagBox.contents.value
  def header = headerBox.contents.value
  def code = codeBox.contents.value
  def footer = footerBox.contents.value
  def inputs = inputsBox.contents.value
  def output = outputBox.contents.value

  val runButton: dom.html.Button = button(
    id := "run_button",
    title := "Run Program",
    `type` := "button",
    onclick := { () => JSVyxal.run() },
    i(`class` := "fas fa-play-circle")
  ).render

  val keyboardBox = Collapsible(
    "Keyboard",
    div(`class` := "twelve columns", div(id := "keyboard")).render,
    div(
      `class` := "row",
      style := "width:100%; padding-bottom: 1em;",
      label(
        `for` := "filterBox",
        style := "display:inline-block; color: white; font-family: \"Montserrat\", sans-serif; padding-right: 1%;",
        "Search&nbsp;",
        a(
          href := "https://github.com/Vyxal/Vyxal/blob/main/documents/knowledge/elements.md",
          "elements"
        )
      ),
      input(
        style := "display:inline-block",
        id := "filterBox",
        oninput := { () =>
          /*glyphSearch(); */
          ???
        },
        label("Search for command:")
      )
    )
  )

  val flagBox = Collapsible(
    "Flags",
    textarea(
      name := "flags",
      id := "flag",
      style := "min-height: 2em;"
    ).render
  )

  val headerBox = Collapsible(
    "Header",
    textarea(
      id := "header",
      name := "header"
    ).render
  )

  val codeBox =
    Collapsible(
      "Code",
      textarea(
        id := "code",
        name := "code",
        oninput := { () => JSVyxal.updateCount() },
        onkeyup := { () => JSVyxal.updateCount() }
      ).render
    )

  val footerBox =
    Collapsible("Footer", textarea(id := "footer", name := "footer").render)

  val inputsBox = Collapsible(
    "Inputs",
    textarea(
      id := "inputs",
      name := "inputs"
    ).render
  )

  val outputBox = Collapsible(
    "Output",
    textarea(id := "output", value := "", readonly).render,
    button(
      onclick := { () => JSVyxal.copyToClipboard("output") },
      style := "height:auto; display: inline-block;",
      `type` := "button",
      "Click to copy"
    ).render,
    div(id := "html-rendered-output", hidden).render
  )

  val errorBox = Collapsible(
    "Debug",
    textarea(
      id := "errors",
      name := "errors"
    ).render
  )

  val htmlFrag =
    body(
      onload := { () =>
        JSVyxal.initCodeMirror()
        JSVyxal.decodeUrl()
        JSVyxal.updateCount()
      },
      h2(
        style := "display: inline-block;",
        a(href := "https://github.com/Vyxal/Vyxal", target := "_blank", "Vyxal")
      ),
      runButton,
      button(
        id := "permalink",
        title := "Generate Permalink",
        `type` := "button",
        onclick := { () =>
          JSVyxal.shareOptions(ShareType.Permalink)
          JSVyxal.resizeCodeBox(outputBox.contents)
        },
        i(`class` := "fas fa-link")
      ),
      button(
        id := "post-template",
        title := "Generate Code Golf Submission",
        `type` := "button",
        onclick := { () => JSVyxal.shareOptions(ShareType.PostTemplate) },
        i(`class` := "fas fa-medal")
      ),
      button(
        id := "markdown",
        title := "Generate Inline Markdown",
        `type` := "button",
        onclick := { () => JSVyxal.shareOptions(ShareType.Markdown) },
        i(`class` := "fas fa-markdown")
      ),
      button(
        id := "clear",
        title := "Clear all fields",
        onclick := { () => JSVyxal.clear() },
        i(`class` := "fas fa-redo")
      ),
      keyboardBox.details,
      flagBox.details,
      headerBox.details,
      codeBox.details,
      footerBox.details,
      inputsBox.details,
      outputBox.details,
      errorBox.details
    ).render
}
