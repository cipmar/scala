package ro.mariusr.scala.p02_inheritance

/**
  * This is the base class which will be extended below
  */
class Customer(val name: String, val address: String) {
  private final val basket: ShoppingBasket = new ShoppingBasket(0);

  def add(item: Item) {
    basket.add(item);
  }

  def total: Double = {
    basket.value;
  }
}

/**
  * This overrides Customer class by overriding total method - 10% discount
  * Only primary constructor can call super constructor
  * override keyword is mandatory
  */
class DiscountedCustomer(name: String, address: String) extends Customer(name, address) {
  override def total: Double = {
    super.total * 0.9
  }
}

class ShoppingBasket(var value: Double) {
  def add(item: Item) = value += item.price
}

class Item(var value: Double) {
  def price = value
}

/**
  * Companion object for class Item, defines factory a method
  */
object Item {
  def apply(value: Double) = new Item(value)
}

object Customer {
  def main(args: Array[String]) {
    val c = new Customer("name", "address")
    c.add(Item(1))
    c.add(Item(2))
    c.add(new Item(0) {
      // anonymous class, like in Java
      override def price = 2.4
    })
    println(c.total)
  }
}

object DiscountedCustomer {
  def main(args: Array[String]) {
    val c = new DiscountedCustomer("Marius", "Pepinierei 29C")
    c.add(Item(2))
    c.add(Item(3))
    c.add(new Item(0) {
      // anonymous classes are created in the same way as in Java
      override def price = 2.5
    })
    println(c.total)
  }
}