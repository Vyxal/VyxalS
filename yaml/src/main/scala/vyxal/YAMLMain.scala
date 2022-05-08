package vyxal

import cats.syntax.either._
import io.circe._
import io.circe.yaml
import scala.io.Source
import java.io.FileOutputStream
import scala.collection.mutable

object YAMLMain {
  def main(args: Array[String]): Unit = {
    ToText.run()
    ToMarkdown.run()
  }
}
