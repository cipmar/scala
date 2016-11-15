package ro.mariusr.scala.p06_patternmatching

/**
  * Pattern Matching - Literal Match
  */
object pm_01 {
  def main(args: Array[String]): Unit = {
    def matchMonth(month: String) = month match {
      case "March"     | "April"   | "May" => "It's spring"
      case "June"      | "July"    | "August" => "It's summer"
      case "September" | "October" | "November" => "It's autumn"
      case "December"  | "January" | "February" => "It's winter"
    }

    print(matchMonth("November"))
  }
}
