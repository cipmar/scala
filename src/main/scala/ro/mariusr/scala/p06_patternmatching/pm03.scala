package ro.mariusr.scala.p06_patternmatching

/**
  * Pattern Matching - Case classes matching
  */
object pm03 {
  def main(args: Array[String]): Unit = {
    abstract class Shape
    case class Circle(radius: Int) extends Shape
    case class Square(length: Int) extends Shape
    case class Rectangle(length: Int, width: Int) extends Shape
    case class Triangle(a: Int, b: Int, c: Int) extends Shape

    def perimeter(shape: Shape): Double = shape match {
      case Circle(radius) => 2 * Math.PI * radius
      case Square(length) => 4 * length
      case Rectangle(length, width) => 2 * length + 2 * width
      case Triangle(a, b, c) => a + b + c
      case _ => 0.0
    }

    println(perimeter(Triangle(3, 4, 5)))
  }
}