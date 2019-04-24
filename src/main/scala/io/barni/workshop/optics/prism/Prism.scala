package io.barni.workshop.optics.prism

import io.barni.workshop.optics.iso.Iso

//  Laws
//  getOption(a) map reverseGet == None | Some(a)
//  reverseGet(getOption(b)) == Some(b)


case class Prism[A, B](getOption: A => Option[B], reverseGet: B => A) {
  def isMatching(input: A): Boolean = getOption(input).fold(false)(_ => true) // (getOption andThen (_.fold(false)(_ => true)))(input)

  def modify(f: B => B): A => A = a => (getOption(a) map (f andThen reverseGet)).fold(a)(identity)

  def modifyOption(f: B => B): A => Option[A] = getOption andThen (_ map (reverseGet compose f))

  def compose[C](other: Prism[B, C]): Prism[A, C] = Prism[A, C](getOption andThen (_ flatMap other.getOption), reverseGet compose other.reverseGet)

  def compose[C](other: Iso[B, C]): Prism[A, C] = Prism[A, C](getOption andThen (_ map other.get), reverseGet compose other.reverseGet)
}

object Prism {

  def partial[A, B](get: PartialFunction[A, B])(reverseGet: B => A): Prism[A, B] = Prism[A, B](get.lift, reverseGet)

}
