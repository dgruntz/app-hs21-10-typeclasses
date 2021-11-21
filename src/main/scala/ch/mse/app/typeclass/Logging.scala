package ch.mse.app.typeclass

object Logging {
  import java.io.PrintStream

  given out: PrintStream = System.out
  given datePrefix: String = s"${java.time.LocalDate.now}>>"

  def log(msg: String)(using out: PrintStream): Unit = out.println(msg)
  def logTimed(msg: String)(using out: PrintStream): Unit = log("[" + new java.util.Date + "] " + msg)
  def logPrefixed(msg: String)(using out: PrintStream, prefix: String): Unit = log("[" + prefix + "] " + msg)


  def main(args: Array[String]): Unit = {
    log("Implicits")
    log("Error message")(using System.err)
    logTimed("Hello")
    logTimed("Hello")(using System.err)
    logPrefixed("Hello")
    Thread.sleep(1000)
    logPrefixed("Hello")
    logPrefixed("Hello")(using summon[PrintStream], ">>")
    logPrefixed("Hello")(using summon, summon)
  }
}
