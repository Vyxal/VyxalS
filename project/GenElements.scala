import io.circe.yaml
import scala.io.Source
import java.io.FileOutputStream

object GenElements {
  def run(): Unit = {
    val text = Source.fromFile("documents/knowledge/elements.yaml").mkString

    yaml.parser.parse(text) match {
      case Left(failure) => println(failure)
      case Right(json) => {
        val mdOutStr = new StringBuilder()
        val txtOutStr = new StringBuilder()

        mdOutStr ++= "# Vyxal Elements\n"

        json.asArray.get.foreach { json =>
          val name = (json \\ "name").head.asString.get
          val description = (json \\ "description").head.asString.get

          if ((json \\ "element").nonEmpty) { // It's an element
            val element = (json \\ "element").head.asString.get
            mdOutStr ++= s"\n## `` $element `` ($name)\n\n"
            mdOutStr ++= description + "\n\n"

            txtOutStr ++= s"$element ($name)\n\n"
            txtOutStr ++= s"- $description\n\n"

            val overloads = json \\ "overloads"
            if (overloads.nonEmpty) {
              mdOutStr ++= "### Overloads\n\n"
              overloads.head.asObject.get.toList.foreach {
                case (signature, olDesc) =>
                  val params =
                    signature
                      .split("-")
                      .zipWithIndex
                      .map { case (paramType, i) =>
                        paramType + " " + "abcdef" (i)
                      }
                      .mkString(", ")
                  val desc = olDesc.asString.getOrElse("")
                  mdOutStr ++= s"- $params: `$desc`\n"
                  txtOutStr ++= s"    $params: $desc\n"
              }
              mdOutStr ++= "\n"
            }
            val vectorize = json \\ "vectorise"
            if (vectorize.nonEmpty && vectorize.head.asBoolean.get) {
              txtOutStr ++= "    otherwise: vectorise\n\n"
            }
          } else { // It's a modifier
            val modifier = (json \\ "modifier").head.asString.get
            mdOutStr ++= s"## `` $modifier `` ($name)\n\n"
            mdOutStr ++= description + "\n\n"

            txtOutStr ++= s"$modifier ($name)\n\n"
            txtOutStr ++= s"- $description\n\n"
          }
          mdOutStr.append("-------------------------------\n")
          txtOutStr.append("-------------------------------\n")
        }
        val mdOut = new FileOutputStream("documents/knowledge/elements.md")
        mdOut.write(mdOutStr.toString.getBytes())
        val txtOut = new FileOutputStream("documents/knowledge/elements.txt")
        txtOut.write(txtOutStr.toString.getBytes())
      }
    }
  }
}
