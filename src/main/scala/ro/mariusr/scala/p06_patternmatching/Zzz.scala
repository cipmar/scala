package ro.mariusr.scala.p06_patternmatching

/**
  * Created by mariusrop on 13.12.2016.
  */
object Zzz {
  def sort[A <% Ordered[A]](as: List[A]): List[A] = as match {
    case Nil => Nil
    case a :: as =>
      val (before, after) = as partition (_ < a)
      sort(before) ++ (a :: sort(after))
  }

  def main(args: Array[String]): Unit = {
    println(sort(List(3,4,6,6,7,8,7,5,45,43,2,2,2,0)))
  }
}
