package ro.mariusr.scala.P08_forcomprehensions

import scala.collection.mutable

case class Customer(name: String, address: Option[Address])

case class Address(street: String, postalCode: Option[String])

class Customers {
  var list = new collection.mutable.MutableList[Customer]()

  def add(customer: Customer) {
    list += customer
  }

  def findOrNull(name: String): Customer = {
    list.find(c => c.name.eq(name)).getOrElse(null)
  }

  def find(name: String): Option[Customer] = {
    list.find(c => c.name.eq(name))
  }

  override def toString = list.toString()
}

class CustomersDatabase() {
  val customers = new Customers

  customers.add(Customer("Albert", Some(Address("29C Pepinierei", None))))
  customers.add(Customer("Beatriz", None))
  customers.add(Customer("Carol", Some(Address("1st Muncii", Some("700123")))))
  customers.add(Customer("Sherlock", Some(Address("2nd 9 Mai", Some("700321")))))

  override def toString = customers.toString()
}

// we want to get the shipping addresses of customers with full address information, including postalCode

object Example1 {
  val database = new CustomersDatabase
  val all = List("Albert", "Carol", "Beatriz", "Sherlock", "John", "Tom", null)

  def shippingAddress(name: String, street: String, postalCode: String): String = name + ", " + street + " " + postalCode

  def generateShippingAddresses1() = {
    val labels = mutable.Set[String]()

    /**
      * naive solution
      */
    all.foreach { name =>
      val customer = database.customers.findOrNull(name)
      if (customer != null) {
        val address = customer.address
        if (address.isDefined) {
          val postalCode = address.get.postalCode
          if (postalCode.isDefined) {
            labels.add(shippingAddress(customer.name, address.get.street, postalCode.get))
          }
        }
      }
    }

    labels
  }

  def generateShippingAddresses2() = {
    all.flatMap {
      name => database.customers.find(name).flatMap {
        customer => customer.address.flatMap {
          address => address.postalCode.map {
            postalCode => shippingAddress(name, address.street, postalCode)
          }
        }
      }
    }
  }

  /**
    * for comprehension
    */
  def generateShippingAddresses3() = {
    for {
      name <- all                                       // <-- flatMap
      customer <- database.customers.find(name)         // <-- flatMap
      address <- customer.address                       // <-- flatMap
      postalCode <- address.postalCode                  // <-- map
    } yield {
      shippingAddress(name, address.street, postalCode) // <-- mapping function
    }
  }

  def main(args: Array[String]) {
    println(generateShippingAddresses1())
    println(generateShippingAddresses2())
    println(generateShippingAddresses3())
  }
}

