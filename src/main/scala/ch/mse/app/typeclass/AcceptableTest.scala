package ch.mse.app.typeclass

object AcceptableTest {

  def foo[T : Acceptable](x: T) = println(x)
  
  def main(args: Array[String]): Unit = {
    foo(1)
    foo(2L)
    // foo(3.3)
    // foo("Hello")
  }

}