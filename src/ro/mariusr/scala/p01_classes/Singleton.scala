package ro.mariusr.scala.p01_classes

import java.util.logging.Level

/**
  * Scala has a language feature to construct singleton objects: object
  * Try decompile the class file with
  * http://www.benf.org/other/cfr/
  *
  * The output would be a class similar with how Java implements a singleton - one single statically initialized instance
  */
object Logger {
  def log(level: Level, message: String): Unit = {
    printf("%s %s\n", level, message);
  }

  def main (args: Array[String]) {
    Logger.log(Level.INFO, "Catastrophic failure!")
  }
}