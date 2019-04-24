package io.barni.workshop.optics.iso

case class Iso[A, B](get: A => B, reverseGet: B => A) {

  def compose[C](other: Iso[B, C]): Iso[A, C] =
    Iso[A, C](get andThen other.get, other.reverseGet andThen reverseGet)

  def modify(f: A => A): B => B = reverseGet andThen f andThen get

  lazy val reverse: Iso[B, A] =
    Iso[B, A](reverseGet, get)

}
