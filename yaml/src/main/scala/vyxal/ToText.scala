package vyxal

import cats.syntax.either._
import io.circe._
import io.circe.yaml
import scala.io.Source
import java.io.FileOutputStream
import scala.collection.mutable

object ToText {
  def run(): Unit = {
    val str: String = Source.fromFile("documents/knowledge/elements.yaml").mkString
    val json: Either[ParsingFailure, Json] = yaml.parser.parse(str)

    val text = StringBuilder()

    json match {
      case Left(failure) => println(failure)
      case Right(json) => {
        val out = new FileOutputStream("documents/knowledge/elements.txt")
        val outStr = mutable.StringBuilder()
        json.asArray.get.foreach { json =>
          val element = json \\ "element"
          if (element.nonEmpty) {
            outStr.append(element.head.asString.get + " (" + (json \\ "name").head.asString.get + ")\n\n")
            outStr.append("- " + (json \\ "description").head.asString.get + "\n\n")
            val overloads = json \\ "overloads"
            if (overloads.nonEmpty) {
              overloads.head.asObject.get.toList.foreach { (args, ol) =>
                val s = args.split("-")
                val datatypes = s.zip(s.indices).map { (a, i) => a + " " + "abcdef"(i) }
                var joined = datatypes.fold("") { (acc, item) => acc + item + ", " }.dropRight(2)
                outStr.append("    " + joined + ": " + ol.asString.get + "\n")
              }
            }
            val vectorize = json \\ "vectorise"
            if (vectorize.nonEmpty && vectorize.head.asBoolean.get) {
              outStr.append("    otherwise: vectorise\n\n")
            }
          }
          val modifier = json \\ "modifier"
          if (modifier.nonEmpty) {
            outStr.append(modifier.head.asString.get + " (" + (json \\ "name").head.asString.get + ")\n\n")
            outStr.append("- " + (json \\ "description").head.asString.get + "\n\n")
          }
          outStr.append("-------------------------------\n")
        }
        out.write(outStr.toCharArray.map(_.toByte))
      }
    }
  }
}