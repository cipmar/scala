package ro.mariusr.scala

/**
  * Default constructor with two parameters: name, address
  * Getter methods for name and address; no setters
  */
class Customer1(val name: String, val address: String) {
}

/**
  * Default constructor with two parameters: name, address
  * Getter methods for name and address
  * Setter methods for name and address
  */
class Customer2(var name: String, var address: String) {
}

/**
  * new property id with getter and setter; val would have created only a getter
  * the setter method is generated and named id_$eq (id_=)
  * the fields is public (no access modifiers)
  */
class Customer3(var name: String, var address: String) {
  var id = "";
}

/**
  * Overriding the setter for id field:
  * 1. rename the field (for example _id)
  * 2. mark as private
  * 3. recreate setter and getter with the original name
  */
class Customer4(val name: String, val address: String) {
  // the internal private field
  private var _id = "";

  // the getter
  def id = _id

  // the setter
  def id_=(value: String) {
    if (_id.isEmpty)
      _id = value;
  }
}

object Customer {
  def main(args: Array[String]) {
    val eric1 = new Customer1("Eric", "Pepinierei 29C, Iasi")
    println(eric1.name)

    val eric2 = new Customer2("Edic", "Pepinierei 29B");
    eric2.name = "Marius";
    eric2.address_=("Palas 7E")
    println(eric2.name)

    val eric3 = new Customer3("Eric", "Pepinierei 29A")
    eric3.id_=("1111")
    println(eric3.id)

    val eric4 = new Customer4("Eric", "Pepinirei 28")
    eric4.id = "1001"
    eric4.id = "1002"
    println(eric4.id)
  }
}
