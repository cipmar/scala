package ro.mariusr.scala.p06_patternmatching

/**
  * Created by mariusrop on 10.11.2016.
  */
object Sample_01 {
  def main(args: Array[String]): Unit = {
    case class SuperHero(heroName: String, alterEgo: String, powers: List[String])

    val hero = new SuperHero("Batman", "Bruce Wayne", List("Speed", "Agility"))

    hero match {
      case SuperHero(_, "Bruce Wayne", _) => println("I'm batman!")
      case SuperHero(_, _, _) => println("???")
    }
  }
}
