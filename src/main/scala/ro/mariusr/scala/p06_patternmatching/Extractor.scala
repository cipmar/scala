package ro.mariusr.scala.p06_patternmatching

/*
Extractor pattern
 */

/*
The return type of an unapply should be chosen as follows:
If it is just a test, return a Boolean. For instance case even()
If it returns a single sub-value of type T, return an Option[T]
If you want to return several sub-values T1,...,Tn, group them in an optional tuple Option[(T1,...,Tn)].
 */

/**
  * Created by mariusrop on 21.12.2016.
  */
object Extractor {
  class Division(val dividend: Int, val divisor: Int)

  object Division {
    def unapply(division: Division): Option[(Int, Int)] = Some((division.dividend, division.divisor))
  }

  def eval(division: Division) = division match {
    case Division(_, 0) => "Division by zero!"
    case Division(a, b) => a / b
  }

  def main(args: Array[String]): Unit = {
    println(eval(new Division(10, 0)))
    println(eval(new Division(20, 2)))
  }
}
