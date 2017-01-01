package ro.mariusr.scala.p07_map_flatmap

class Mappable[A](elements: A*) {
  def map[B](f: A => B): List[B] = {
    var result = collection.mutable.MutableList[B]()

    elements.foreach {
      result += f.apply(_)
    }

    result.toList
  }

  def flatMap[B](f: A => List[B]): List[B] = {
    var result = collection.mutable.MutableList[B]()

    elements.foreach {
      f.apply(_).foreach {
        result += _
      }
    }
    result.toList
  }
}

object MapExample {
  def oddNumbers(end: Int): List[Int] = {
    var odds = collection.mutable.MutableList[Int]()

    for (i <- 0 to end) {
      if (i % 2 > 0) odds += i;
    }

    odds.toList
  }

  def main(args: Array[String]) {
    val mappable = new Mappable(1, 2, 3, 7, 8)

    val mapResult = mappable.map(_ * 2)
    println(mapResult)

    val mapResult2 = mappable.map(oddNumbers)
    println(mapResult2)

    val flatResult = mappable.flatMap(oddNumbers)
    println(flatResult)
  }
}