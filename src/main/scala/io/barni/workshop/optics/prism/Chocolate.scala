package io.barni.workshop.optics.prism

sealed trait Chocolate extends Product with Serializable //
object Chocolate {

  case object MilkyWay extends Chocolate //
  final case class Mars(caramelType: String) extends Chocolate //
  final case class Snickers(caramelType: String, nrOfPeanuts: Int) extends Chocolate //
  final case class Bounty(coconutMass: Int) extends Chocolate

  sealed abstract class ChocolateBar(weight: Int, name: String) extends Chocolate

  final case class Milka(weight: Int) extends ChocolateBar(weight, "Milka") //
  final case class Boci(weight: Int) extends ChocolateBar(weight, "Boci") //
  final case class PirosMogyoros(weight: Int) extends ChocolateBar(weight, "PirosMogyoros")

}