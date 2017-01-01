package ro.mariusr.scala.p09_tailrecursion

import scala.annotation.tailrec

/**
  * Created by mariusrop on 02.01.2017.
  */
object Fib {

  def fibNonTailRec(i: Int): Int = {
    i match {
      case 0 => 0
      case 1 => 1
      case _ => fibNonTailRec(i - 1) + fibNonTailRec(i - 2)
    }
  }

  @tailrec
  def fibTailRec(i: Int, prev: BigInt = 0, next: BigInt = 1): BigInt = i match {
    case 0 => prev
    case 1 => next
    case _ => fibTailRec(i - 1, next, (next + prev))
  }

  def main(args: Array[String]): Unit = {
    println(fibNonTailRec(7))
    println(fibTailRec(7))
  }
}
