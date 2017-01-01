package ro.mariusr.scala.p06_patternmatching

/**
  * Pattern Matching - Literal Match, matching against different types
  */
object pm02 {
  def main(args: Array[String]): Unit = {
    def matchMonth(month: Any) = month match {
      case 3 | 4 | 5 | "March" | "April" | "May" => "It's spring!"
      case 6 | 7 | 8 | "June" | "July" | "August" => "It's summer!"
      case 9 | 10 | 11 | "September" | "October" | "November" => "It's autumn!"
      case 12 | 1 | 2 | "December" | "January" | "February" => "It's winter!"
      case _: Int => "Invalid int month"
      case _: String => "Invalid string month"
    }

    println(matchMonth(11))
  }
}
