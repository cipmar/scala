package ro.mariusr.scala.p09_tailrecursion

import scala.annotation.tailrec

/**
  * Created by mariusrop on 01.01.2017.
  */
object Sum {
  def sumNonTailrec(list: List[Int]): Int = {
    list match {
      case Nil => 0
      case head :: tail => head + sumNonTailrec(tail)
    }
  }

  def sumTailRec(list: List[Int]): Int = {
    @tailrec
    def sumAccumulator(list: List[Int], acc: Int): Int = {
      list match {
        case Nil => acc
        case head :: tail => sumAccumulator(tail, head + acc)
      }
    }

    sumAccumulator(list, 0)
  }

  def sumReduceLeft(list: List[Int]): Int = {
    list.reduceLeft(_ + _)
  }

  def main(args: Array[String]): Unit = {
    println(sumNonTailrec(List(1, 2, 3, 6, 7)))
    println(sumTailRec(List(1, 2, 3, 6, 7)))
    println(sumReduceLeft(List(1, 2, 3, 6, 7)))
  }
}
