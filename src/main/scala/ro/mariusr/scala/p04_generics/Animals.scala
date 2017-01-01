package ro.mariusr.scala.p04_generics

class Animal extends Comparable[Animal] {
  override def compareTo(o: Animal): Int = 0
}

class Lion extends Animal {}

class Zebra extends Animal {}

object Animal {
  def main(args: Array[String]) {
    var lions = List[Lion]()
    lions = new Lion +: lions
    lions = new Lion +: lions
    sort[Lion, Animal](lions)

    var animals = List[Animal]()
    animals = new Lion +: animals;
    animals = new Zebra +: animals;
    sort(animals)
  }

  def sort[A <: Comparable[U], U >: A](list: List[A]) = {
    list
  }
}
