package ro.mariusr.scala.p06_patternmatching

/**
  * Created by mariusrop on 21.12.2016.
  */
object Arrays {
  def main(args: Array[String]): Unit = {
    val array = Array(1)

    array match {
      case Array(a, b, _*) => print("at least two elements")
      case Array(a, _*) => print("one element")
    }

/*
    def fib(a: Array[Int]) = a match {
      case Array(a, b, rest) => a + b + fib(rest)
    }
*/
  }
}
