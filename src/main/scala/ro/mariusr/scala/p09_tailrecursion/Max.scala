package ro.mariusr.scala.p09_tailrecursion

import scala.annotation.tailrec

/**
  * Created by mariusrop on 02.01.2017.
  */
object Max {
  def maxWithMatch(list: List[Int]): Int = {
    @tailrec
    def maxAccumulator(list: List[Int], theMax: Int): Int = {
      list match {
        case Nil => theMax
        case head :: tail =>
          if (head > theMax)
            maxAccumulator(tail, head)
          else
            maxAccumulator(tail, theMax)
      }
    }

    maxAccumulator(list, Int.MinValue)
  }

  def maxWithIfElse(list: List[Int]): Int = {
    @tailrec
    def maxAccumulator(list: List[Int], theMax: Int): Int = {
      if (list.isEmpty) {
        theMax
      } else {
        if (list.head > theMax)
          maxAccumulator(list.tail, list.head)
        else
          maxAccumulator(list.tail, theMax)
      }
    }

    maxAccumulator(list, Int.MinValue)
  }

  def main(args: Array[String]): Unit = {
    println(maxWithMatch(List(1, 4, 3, 2, 9, 6, 7, 3, 2)))
    println(maxWithIfElse(List(1, 4, 3, 2, 9, 6, 7, 3, 2)))
  }
}
