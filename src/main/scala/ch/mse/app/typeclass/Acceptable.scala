package ch.mse.app.typeclass

abstract class Acceptable[T]

object Acceptable {
  given Acceptable[Int] with {}
  given Acceptable[Long] with {}
}
