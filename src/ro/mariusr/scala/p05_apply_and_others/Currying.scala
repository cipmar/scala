package ro.mariusr.scala.p05_apply_and_others

/**
  * What the hell is currying?
  *
  * Currying is the process of turning a function of two or more arguments into a series of functions, each taking
  * a single argument!
  */

/**
  * phase 1... doesn't look so good
  */
object Currying1 extends DoSomeWork {

  runInThreadGroup("group1", {
    doSomeWork("thread 1 says hello")
  })

  runInThreadGroup("group1", {
    doSomeWork("thread 1 says hello")
  })

  def runInThreadGroup(group: String, function: => Unit) {
    new Thread(new ThreadGroup(group), new Runnable() {
      override def run = function
    }).start();
  }
}

/**
  * Look, I'm currying functions! Take a look at runInThreadGroup method
  */
object Currying2 extends DoSomeWork {

  runInThreadGroup("group1") {
    doSomeWork("thread 1 says hello")
  }

  runInThreadGroup("group1") {
    doSomeWork("thread 1 says hello")
  }

  def runInThreadGroup(group: String)(function: => Unit) {
    new Thread(new ThreadGroup(group), new Runnable() {
      override def run = function
    }).start();
  }
}


trait DoSomeWork {
  def doSomeWork(message: String): Unit = {
    println("this is what I was told to say: " + message)
  }
}
