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
              val cm = globalThis[s"e_$selectedBox"]
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
  }
}
