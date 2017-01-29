package ro.mariusr.scala.p06_patternmatching

import scala.collection.SeqLike

/**
  * Created by mariusrop on 21.12.2016.
  */
object Arrays {
  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4)

    array match {
      case Array(x, y, _*) => print(s"first element - $x, second one - $y")
      case Array(x, _*) => print("only one element")
      case _ => println("empty!")
    }
    println(Array.unapplySeq(array).get.lengthCompare(8))
  }
}
