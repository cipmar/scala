package ro.mariusr.scala.p05_apply_and_others

/**
  * In some cases parentheses can be replaced by curly braces so as to allow more succinct code constructs.
  * Why? So as to allow functions to pass other function as argument in a more natural way... these are higher order functions!
  *
  * Curly Braces rule:
  * In any method call, in which you pass in exactly one argument, you can use curly braces to surround that argument
  * instead of parentheses
  */

/**
  * phase 1...
  */
object CurlyBraces extends SomeWorkToDo {
  def main(args: Array[String]) {
    new Thread() {
      override def run() = workDoneInThread("thread 1 says hello");
    }.start()

    new Thread() {
      override def run() = workDoneInThread("thread 2 says hello also")
    }.start()
  }
}

/**
  * phase 2...
  */
object CurlyBraces2 extends SomeWorkToDo {
  def main(args: Array[String]) {

    runInThread(() => workDoneInThread("thread 1 says hello"))
    runInThread(() => workDoneInThread("thread 2 says hello also"))

    def runInThread(function: () => Unit) {
      new Thread() {
        override def run() = function()
      }.start()
    }
  }
}

/**
  * phase 3...
  *
  * now, we replace the parentheses with curly braces and () can be omitted - for no argument lambda
  * we also remove the () from argument function in runInThread method...
  *
  * beautiful !!!
  */
object CurlyBraces3 extends SomeWorkToDo {
  def main(args: Array[String]) {

    runInThread {
      workDoneInThread("thread 1 says hello")
      workDoneInThread("thread 1 says hello again")
      workDoneInThread("thread 1 says hello third time")
    }

    runInThread {
      workDoneInThread("thread 2 says hello")
    }

    def runInThread(function: => Unit) {
      new Thread() {
        override def run() = function
      }.start()
    }
  }
}

trait SomeWorkToDo {
  def workDoneInThread(message: String) {
    println("Work done in thread. Message: " + message)
  }
}