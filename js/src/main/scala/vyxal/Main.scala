package vyxal

import scala.scalajs.js

import org.scalajs.dom.{document, window}

object Main {
  def main(args: Array[String]): Unit = {
    window.addEventListener(
      "DOMContentLoaded",
      event => {
        val kb = document.getElementById("keyboard")
        for (i <- codepage.indices) {
          kb.innerHTML += (`<span class=\"key\" style="text-align:center;" title='`
            + repr(codepage_descriptions[i])
            + `'>${codepage[i]}</span>`)
        }
        for (item <- document.querySelectorAll(".key")) {
          item.addEventListener(
            "click",
            event => {
              val char = replaceHTMLChar(event.target.innerHTML)
              val cm = globalThis(s"e_$selectedBox")
              cm.replaceSelection(char)
              cm.save()
              cm.focus()
              JSVyxal.updateCount()
            }
          )
        }
        og_keyboard_html = document.getElementById("keyboard").innerHTML
      }
    )

    window.addEventListener(
      "DOMContentLoaded",
      e => {
        val run = document.getElementById("run_button")

        val stdin = document.getElementById("inputs")
        val flags = document.getElementById("flag")
        val output = document.getElementById("output")
        val extra = document.getElementById("extra")
        val filter = document.getElementById("filterBox")

        def do_run() = {
          if (!run.innerHTML.includes("fa-spin")) {
            run.innerHTML =
              """<svg class="fa-spin" style="width:24px;height:24px" viewBox="0 0 24 24">
                    <path fill="currentColor" d="M12,4V2A10,10 0 0,0 2,12H4A8,8 0 0,1 12,4Z"/>
                </svg>""";
            output.value = "";
            extra.value = "";

            Vyxal.execute(
              e_header.doc.getValue() + e_code.doc.getValue() + e_header.doc
                .getValue(),
              stdin.value.split("\n"),
              flags.map(_.toString),
              out => output.value += out,
              warn => extra.value += warn,
              err => extra.value += err
            )

            expandBoxes()
          } else {
            // todo kill if already running
          }
        }

        $("#run_button").on("click", do_run)

        $("#clear").on(
          "click",
          e => {
            e_code.doc.setValue("")
            stdin.value = ""
            output.value = ""
            extra.value = ""
            e_footer.doc.setValue("")
            e_header.doc.setValue("")
            updateCount()
            flags.value = ""
            filter.value = ""
            glyphSearch()
            expandBoxes()
          }
        )

      }
    )

    document.addEventListener(
      "keydown",
      (event) => {
        if (event.metaKey && event.key == "Enter") {
          $("#run_button").click()
        }
      }
    )

  }
}
