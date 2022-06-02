package vyxal

import scalatags.JsDom.all.*

object Index {

  // ScalaTags doesn"t define these for some reason
  val details = tag("details")
  val summary = tag("summary")
  val open = attr("open").empty

  val dummy = textarea(id := "dummy").render

  val runButton = button(
    id := "run_button",
    title := "Run Program",
    `type` := "button",
    onclick := "this.blur()",
    i(`class` := "fas fa-play-circle")
  ).render

  val htmlFrag = html(
    head(
      meta(charset := "utf-8"),
      meta(httpEquiv := "Permissions-Policy", content := "interest-cohort=()"),
      meta(
        name := "viewport",
        content := "width=device-width, initial-scale=1, shrink-to-fit=no"
      ),
      title := "Vyxal Interpreter",
      link(
        rel := "stylesheet",
        href := "https://cdnjs.cloudflare.com/ajax/libs/skeleton/2.0.4/skeleton.min.css",
        integrity := "sha512-EZLkOqwILORob+p0BXZc+Vm3RgJBOe1Iq/0fiI7r/wJgzOFZMlsqTa29UEl6v6U6gsV4uIpsNZoV32YZqrCRCQ==",
        crossorigin := "anonymous"
      ),
      script(
        src := "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js",
        integrity := "sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==",
        crossorigin := "anonymous"
      ),
      link(rel := "preconnect", href := "https://fonts.gstatic.com"),
      link(
        href := "https://fonts.googleapis.com/css2?family=Montserrat:wght@200&display=swap",
        rel := "stylesheet"
      ),
      script(
        src := "https://kit.fontawesome.com/646af2e33b.js",
        crossorigin := "anonymous"
      ),
      link(
        rel := "shortcut icon",
        `type` := "image/jpg",
        href := "https://raw.githubusercontent.com/Lyxal/Vyxal/master/templates/favicon.ico"
      ),
      script(
        src := "https://cdn.jsdelivr.net/npm/codemirror@5.62.0/lib/codemirror.min.js"
      ),
      link(
        rel := "stylesheet",
        href := "https://cdn.jsdelivr.net/npm/codemirror@5.62.0/lib/codemirror.min.css"
      ),
      script(src := "https://vyxal.github.io/Vylight/mode-vyxal.js"),
      link(
        rel := "stylesheet",
        href := "https://vyxal.github.io/Vylight/mode-vyxal.css"
      ),
      script(`type` = "text/javascript", src := "./js/lib/main.js"),
      script(src := "main.js"),
      script(src := "parsed_yaml.js"),
      link(rel := "stylesheet", `type` = "text/css", href := "css/main.css")
    ),
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
        onclick := {
          JSVyxal.shareOptions("permalink")
          JSVyxal.resizeCodeBox("output")
        },
        i(`class` := "fas fa-link")
      ),
      button(
        id := "post-template",
        title := "Generate Code Golf Submission",
        `type` := "button",
        onclick := {
          JSVyxal.shareOptions("post-template")
          JSVyxal.resizeCodeBox("output")
        },
        i(`class` := "fas fa-medal")
      ),
      button(
        id := "markdown",
        title := "Generate Inline Markdown",
        `type` := "button",
        onclick := {
          JSVyxal.shareOptions("markdown")
          JSVyxal.resizeCodeBox("output")
        },
        i(`class` := "fas fa-markdown")
      ),
      button(
        id := "clear",
        title := "Clear all fields",
        i(`class` := "fas fa-redo")
      ),
      details(
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
              "elements&nbsp;"
            )
          ),
          input(
            style := "display:inline-block",
            id := "filterBox",
            oninput := "glyphSearch()",
            label("Search for command:")
          )
        ),
        div(`class` := "twelve columns", div(id := "keyboard"))
      )
    ),
    details(
      id := "flag-detail",
      summary("Flags"),
      input(
        `type` := "text",
        name := "flags",
        id := "flag",
        style := "min-height: 2em;"
      )
    ),
    details(
      id := "header-detail",
      summary("Header"),
      textarea(
        id := "header",
        name := "header",
        oninput := { JSVyxal.resizeCodeBox("header") }
      )
    ),
    details(
      open,
      id := "code-detail",
      summary(id := "code-count", "Code: 0 bytes"),
      textarea(
        id := "code",
        name := "code",
        oninput := { JSVyxal.resizeCodeBox("code"); JSVyxal.updateCount() },
        onkeyup := "updateCount()"
      )
    ),
    details(
      id := "footer-detail",
      summary("Footer"),
      textarea(id := "footer", name := "footer")
    ),
    details(
      open,
      id := "inputs-detail",
      summary("Inputs"),
      textarea(
        id := "inputs",
        name := "inputs",
        oninput := { JSVyxal.resizeCodeBox("inputs") }
      )
    ),
    details(
      id := "output-detail",
      summary(style := "display: inline-block;", "Output"),
      button(
        onclick := { JSVyxal.copyToClipboard("output") },
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
