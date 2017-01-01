package ro.mariusr.scala.p01_classes

/**
  * Scala doesn't have the static keyword or something equivalent.
  * For static methods Scala uses companion objects: objects with the same name as the class and located in the same file
  *
  * Companion objects could be used, for example, for factory methods
  */
class Customer6(val name: String, val address: String) {
  private val id = Customer6.nextId()
}

object Customer6 {
  private var sequenceOfIds = 0

  private def nextId() = {
    sequenceOfIds += 1
    sequenceOfIds
  }

  def apply(name: String, address: String) = {
    new Customer6(name, address)
  }

  def main(args: Array[String]) {
    val c1 = new Customer6("Marius", "Pepinierei 29C")
    val c2 = new Customer6("Lucia", "Pepinierei 29C")

    // apply has a special meaning, it could be omitted - it could be seen as a default method of a class
    val c3 = Customer6("Maria", "Pepinierei 29C")

    println(c1.id)
    println(c2.id)
    println(c3.id)
  }
}