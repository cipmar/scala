package ro.mariusr.scala.p06_patternmatching

/**
  * Created by Marius on 29.01.2017.
  */
object Lists {
  def main(args: Array[String]): Unit = {
      def sum(list: List[Int]): Int = {
        list match {
          case Nil => 0
          case head :: tail => head + sum(tail)
        }
      }

    var list = List(1, 3)

    list match {
      case a :: b :: tail => print(s"at least two elements: $a, $b; tail: $tail")
      case a :: Nil => print(s"the list has exactly one element: $a ")
      case Nil => print("the list is empty")
    }

    println(sum(list))
  }
}
