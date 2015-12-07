package ro.mariusr.scala.p06_patternmatching

import java.net.{MalformedURLException, URL}

/**
  * apply - used to create factory style creation method; apply method takes some arguments and gives back an object
  * apply(a, b) -> object(a, b)
  *
  * unapply - the opposite of apply - it takes an instance object and it gives gives back the values used to construct it
  * unapply(object(a, b)) -> a, b
  *
  * a class that implements unapply is names extractor class - given an object, an extractor typically extracts the
  * parameters that would have created that object
  */

class Customer(val name: String, val address: String)

object Customer {
  def unapply(customer: Customer): Option[(String, String)] = Some(customer.name, customer.address)

  def apply(name: String, address: String) = new Customer(name, address)

  def main(args: Array[String]) {
    val customer = Customer("Bob", "Pepinierei 29C")

    customer match {
      case Customer("Bob", _) => println("This is Bob")
    }
  }
}

/**
  * another example
  */
object UrlExtractor {
  def unapply(string: String): Option[(String, String)] = {
    try {
      val url = new URL(string)
      Some(url.getProtocol, url.getHost)
    } catch {
      case _: MalformedURLException => None
    }
  }

  def main(args: Array[String]) {
    val url = "http://www.google.ro" match {
      case UrlExtractor(protocol, host) => println(protocol + " " + host)
    }
  }
}
