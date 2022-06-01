// todo turn this into Scala later

var codepage = "λƛ¬∧⟑∨⟇÷×«␤»°•ß†€"
codepage += "½∆ø↔¢⌐æʀʁɾɽÞƈ∞¨␠"
codepage += "!\"#$%&'()*+,-./01"
codepage += "23456789:;<=>?@A"
codepage += "BCDEFGHIJKLMNOPQ"
codepage += "RSTUVWXYZ[\\]`^_abc"
codepage += "defghijklmnopqrs"
codepage += "tuvwxyz{|}~↑↓∴∵›"
codepage += "‹∷¤ð→←βτȧḃċḋėḟġḣ"
codepage += "ḭŀṁṅȯṗṙṡṫẇẋẏż√⟨⟩"
codepage += "‛₀₁₂₃₄₅₆₇₈¶⁋§ε¡"
codepage += "∑¦≈µȦḂĊḊĖḞĠḢİĿṀṄ"
codepage += "ȮṖṘṠṪẆẊẎŻ₌₍⁰¹²∇⌈"
codepage += "⌊¯±₴…□↳↲⋏⋎꘍ꜝ℅≤≥"
codepage += "≠⁼ƒɖ∪∩⊍£¥⇧⇩ǍǎǏǐǑ"
codepage += "ǒǓǔ⁽‡≬⁺↵⅛¼¾Π„‟"

search = window
glyphQuery = String.fromCharCode(0162, 105, 0143, 107)
this.prevQuery = ""
secret = "dQw4"
secret += secret[2]
temp = "9WgXc"
secret += temp + secret[1]
temp = "out"
temp += temp[1] + "."
temp += "be"
temp = "y" + temp
temp = codepage[47] + temp
temp = codepage[115] + codepage[58] + temp[0] + temp
secret = "tp" + temp + "/" + secret
secret = "h" + codepage[116] + secret


var og_keyboard_html
var selectedBox = 'code' //whether 'header', 'code', or 'footer' are selected


window.addEventListener("DOMContentLoaded", e => {
    const run = document.getElementById("run_button")

    const stdin = document.getElementById("inputs")
    const flags = document.getElementById("flag")
    const output = document.getElementById("output")
    const extra = document.getElementById("extra")
    const filter = document.getElementById("filterBox")

    function do_run() {
        if (!run.innerHTML.includes("fa-spin")) {
            run.innerHTML =
                `<svg class="fa-spin" style="width:24px;height:24px" viewBox="0 0 24 24">
                    <path fill="currentColor" d="M12,4V2A10,10 0 0,0 2,12H4A8,8 0 0,1 12,4Z"/>
                </svg>`;
            output.value = "";
            extra.value = "";

            Vyxal.execute(
                e_header.doc.getValue() + e_code.doc.getValue() + e_header.doc.getValue(),
                stdin.value.split("\n"),
                [...flags.value],
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

    $("#clear").on("click", e => {
        e_code.doc.setValue('')
        stdin.value = ""
        output.value = ""
        extra.value = ""
        e_footer.doc.setValue('')
        e_header.doc.setValue('')
        updateCount()
        flags.value = ""
        filter.value = ""
        glyphSearch()
        expandBoxes()
    })

})

document.addEventListener('keydown', (event) => {
    if (event.metaKey && event.key == 'Enter') {
        $("#run_button").click()
    }
})
