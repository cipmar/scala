package ro.mariusr.scala.p09_tailrecursion

import scala.annotation.tailrec

/**
  * Created by mariusrop on 02.01.2017.
  */
object Fact {

  def factNonTailrec(n: Int): Int = n match {
    case 0 => 1
    case _ => n * factNonTailrec(n - 1)
  }

  def factTailrec(n: Int): Int = {
    @tailrec
    def factAcc(n: Int, acc: Int): Int = n match {
      case 0 => acc
      case _ => factAcc(n - 1, n * acc)
    }

    factAcc(n, 1)
  }

  def main(args: Array[String]): Unit = {
    println(factNonTailrec(5))
    println(factTailrec(5))
  }
}
