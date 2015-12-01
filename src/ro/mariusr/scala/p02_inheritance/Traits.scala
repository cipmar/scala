package ro.mariusr.scala.p02_inheritance

import scala.collection.mutable

/**
  * traits are similar to Java interfaces
  * traits can have default method implementations (like Java 8 default methods)
  * traits can have fields!
  * traits cam't have constructor arguments (abstract classes can have)
  */
trait Sortable[A <: Ordered[A]] extends Iterable[A] {
  def sort: Seq[A] = {
    this.toList.sorted
  }
}

class MyCustomer(val name: String, address: String) extends Ordered[MyCustomer] {
  override def compare(that: MyCustomer): Int = name.compareTo(that.name)

  override def toString = name
}

object MyCustomer {
  def apply(name: String, address: String) = new MyCustomer(name, address)
}

class Customers extends Sortable[MyCustomer] {
  private val customers = mutable.Set[MyCustomer]()

  def add(c: MyCustomer) = customers.add(c)

  override def iterator: Iterator[MyCustomer] = customers.iterator
}

object Customers {
  def main(args: Array[String]) {
    val customers = new Customers()
    customers.add(MyCustomer("John", "Copou 20"))
    customers.add(MyCustomer("Mary", "Pacurari 21"))
    customers.add(MyCustomer("Anna", "Copou 20"))
    customers.add(MyCustomer("Ben", "Pepinierei 20"))

    println(customers.sort)
  }
}