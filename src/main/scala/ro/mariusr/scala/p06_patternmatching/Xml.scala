package ro.mariusr.scala.p06_patternmatching

import scala.xml.Node

/**
  * XML patterns
  */
object Xml {
  def main(args: Array[String]): Unit = {
    val book =
      <book id="bk101">
        <author id="123">Steve McConnell</author>
        <title>Code Complete</title>
        <description>The best practical guides to programming.</description>
      </book>

    def handleBookNode(bookNode: Node) = bookNode match  {
      case <author>{author}</author> => println(s"Author: $author")
      case <title>{title}</title> => println(s"Title: $title")
      case <description>{description}</description> => println(s"Description: $description")
      case _ => println("Oops")
    }
  }
}
