package ro.mariusr.scala.p04_generics

/**
  * Very similar to Java...
  */
trait Stack[T] {
  def push(t: T)

  def pop: T
}

class ListStack[T] extends Stack[T] {
  private var elements: List[T] = List()

  override def push(t: T): Unit = {
    elements = t +: elements;
  }

  override def pop: T = {
    if (elements.isEmpty) {
      throw new IndexOutOfBoundsException
    }
    val head = elements.head
    elements = elements.tail
    head
  }

  override def toString = {
    elements.map(e => e.toString).reduceLeft((acc, elem) => acc + " " + elem)
  }
}

object ListStack {
  def main(args: Array[String]) {
    val stack = new ListStack[String]()
    stack.push("one")
    stack.push("two")
    stack.push("three")

    println(stack)

    val element = stack.pop
    println(element)
  }
}
