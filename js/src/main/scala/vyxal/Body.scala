package vyxal

import scalatags.JsDom.all.*

object Body {

  // ScalaTags doesn"t define these for some reason
  val details = tag("details")
  val summary = tag("summary")
  val open = attr("open").empty

  val dummy = textarea(id := "dummy").render

  val runButton = button(
    id := "run_button",
    title := "Run Program",
    `type` := "button",
    onclick := { () =>
      this.blur(); Main.run()
    },
    i(`class` := "fas fa-play-circle")
  ).render

  val flagBox = input(
    `type` := "text",
    name := "flags",
    id := "flag",
    style := "min-height: 2em;"
  )

  val headerBox = textarea(
    id := "header",
    name := "header"
  )

  val codeBox = textarea(
    id := "code",
    name := "code",
    oninput := { () => JSVyxal.updateCount() },
    onkeyup := "updateCount()"
  )

  val footerBox = textarea(id := "footer", name := "footer")

  val inputsBox = textarea(
    id := "inputs",
    name := "inputs"
  )

  val outputBox = textarea(
    id := "output",
    name := "output"
  )

  val htmlFrag =
    body(
      onload := {
        JSVyxal.initCodeMirror()
        JSVyxal.decodeUrl()
        JSVyxal.updateCount()
      },
      dummy,
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
          JSVyxal.shareOptions("permalink")
          JSVyxal.resizeCodeBox("output")
        },
        i(`class` := "fas fa-link")
      ),
      button(
        id := "post-template",
        title := "Generate Code Golf Submission",
        `type` := "button",
        onclick := { () => JSVyxal.shareOptions("post-template") },
        i(`class` := "fas fa-medal")
      ),
      button(
        id := "markdown",
        title := "Generate Inline Markdown",
        `type` := "button",
        onclick := { () => JSVyxal.shareOptions("markdown") },
        i(`class` := "fas fa-markdown")
      ),
      button(
        id := "clear",
        title := "Clear all fields",
        i(`class` := "fas fa-redo")
      ),
      details(
        id := "keyboard-detail",
        summary("Keyboard"),
        div(
          `class` := "row",
          style := "width:100%; padding-bottom: 1em;",
          label(
            `for` := "filterBox",
            style := "display:inline-block; color: white; font-family: \"Montserrat\", sans-serif; padding-right: 1%;",
            "Search",
            a(
              href := "https://github.com/Vyxal/Vyxal/blob/main/documents/knowledge/elements.md",
              "elements"
            )
          ),
          input(
            style := "display:inline-block",
            id := "filterBox",
            oninput := { () => /*glyphSearch(); */ ??? },
            label("Search for command:")
          )
        ),
        div(`class` := "twelve columns", div(id := "keyboard"))
      ),
      details(
        id := "flag-detail",
        summary("Flags"),
        flagBox
      ),
      details(
        id := "header-detail",
        summary("Header"),
        headerBox
      ),
      details(
        open,
        id := "code-detail",
        summary(id := "code-count", "Code: 0 bytes"),
        codeBox
      ),
      details(
        id := "footer-detail",
        summary("Footer"),
        footerBox
      ),
      details(
        open,
        id := "inputs-detail",
        summary("Inputs"),
        inputsBox
      ),
      details(
        id := "output-detail",
        summary(style := "display: inline-block;", "Output"),
        button(
          onclick := { () => JSVyxal.copyToClipboard("output") },
          style := "height:auto; display: inline-block;",
          `type` := "button",
          "Click to copy"
        ),
        div(id := "html-rendered-output", hidden),
        textarea(id := "output", value := "", readonly)
      ),
      details(
        id := "extra-detail",
        summary("Debug"),
        textarea(value := "", id := "extra", readonly)
      )
    )

}
