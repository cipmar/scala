package ro.mariusr.scala.p05_apply_and_others

/**
  * This is about faking method calls: there are special constructs in Scala that will call some special methods like
  * apply and update;
  *
  * for example:
  * obj.apply(param) it is same thing as obj(param)
  * obj(param1) = param2 it is same thing as obj.update(param1, param2)
  * obj(param1, param2) = param3 it is same thing as obj.update(param1, param2, param3
  *
  * update can have, as you can see above, multiple parameters: the last one is the value that it is assigned
  */
class Directory {
  private val numbers = scala.collection.mutable.Map(
    "Athos" -> "755 766554",
    "Aramis" -> "755 873766",
    "Porthos" -> "988 876553",
    "Da'Artagnan" -> "755 387268638"
  )

  def apply(name: String) = {
    numbers.get(name)
  }

  def update(name: String, number: String) = {
    numbers.update(name, number)
  }

  def update(areaCode: Int, newAreaCode: String) = {
    // update can have multiple parameters, but only the last one is considered the value that should be updated
    numbers.foreach(entry =>
      if (entry._2.startsWith(areaCode.toString)) {
        numbers(entry._1) = entry._2.replace(areaCode.toString, newAreaCode) // update method is called
      }
    )
  }

  override def toString = numbers.toString
}

object Directory {
  def main(args: Array[String]) {
    // initializing the directory
    val yellowPages = new Directory
    println(yellowPages)

    // changing one number
    yellowPages("Athos") = "xxxxxx" // update method is called
    val number = yellowPages("Athos") // apply method is called
    println(yellowPages)

    // changing area code
    yellowPages(755) = "999"
    println(yellowPages)
  }
}
