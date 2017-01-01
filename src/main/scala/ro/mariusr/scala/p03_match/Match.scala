package ro.mariusr.scala.p03_match

import java.io.{BufferedReader, InputStreamReader}
import java.net.{MalformedURLException, URL}

/**
  * match are like switches in Java, but much more powerful, it can be used to match against Anything!
  */
object Match {
  def main(args: Array[String]) {
    val month = "May"

    // match, like a switch
    val quarter = month match {
      case "January" | "February" | "March" => "1st quarter"
      case "April" | "May" | "June" => "2nd quarter"
      case "July" | "August" | "September" => "3rd quarter"
      case "October" | "November" | "December" => "4th quarter"
    }

    println(quarter)

    // matching exceptions
    try {
      val url = new URL("httpd://www.google.ro")
      val br = new BufferedReader(new InputStreamReader(url.openStream()))
      var line = br.readLine()

      while (line != null) {
        println(line)
        line = br.readLine()
      }
    } catch {
      case e: MalformedURLException => println("Invalid URL!!!")
    }
  }
}
