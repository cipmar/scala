package ro.mariusr.scala.p06_patternmatching

/**
  * pattern types:
  * - wildcard
  * - literal equality
  * - constructor match - allows you to match on the arguments used to construct an object
  * - deconstructor match
  * - type query patterns
  * - a pattern with alternatives
  */
object PatternMatching {
  def literalMatch {
    val language = "French"

    language match {
      case "french" => println("Salut")
      case "French" => println("Bonjour")
      case "German" => println("Guten Tag")
      case _ => println("Hi")
    }
  }

  /**
    * Constructor matching can be applied only on case classes, one of the reason is that case classes
    * implements unapply method - extractor
    */
  def constructorMatch {
    case class SuperHero(heroName: String, alterEgo: String, powers: List[String])

    val hero = new SuperHero("Batman", "Bruce Wayne", List("Speed", "Agility"))

    hero match {
      case SuperHero(_, "Bruce Wayne", _) => println("I'm batman!")
      case SuperHero(_, _, _) => println("???")
    }
  }

  def typeQueryMatch {
    class Person(val name: String)
    case class SuperHero(heroName: String, alterEgo: String, powers: List[String]) extends Person(heroName)

    def nameFor(person: Person) = {
      person match {
        case hero: SuperHero => hero.alterEgo
        case person: Person => person.name
        case _ => "Alien"
      }
    }

    val person = new Person("John")
    val hero = new SuperHero("Batman", "Bruce Wayne", List("Speed", "Agility"))

    println(nameFor(person))
    println(nameFor(hero))
  }

  def main(args: Array[String]) {
    literalMatch
    constructorMatch
    typeQueryMatch
  }
}
