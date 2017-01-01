package ro.mariusr.scala.p01_classes

class Customer5(forename: String, initial: String, surname: String) { // primary constructor
  val fullname = String.format("%s %s. %s", forename, initial, surname)

  // auxiliary constructor should call another auxiliary constructor or the primary constructor
  def this(forename: String, surname: String) {
    this(forename, "", surname)
  }

}
