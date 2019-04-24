package io.barni.workshop.optics.prism

import Chocolate._
import io.barni.workshop.optics.iso.Iso

object ChocolateOptics {

  val MarsPrism: Prism[Chocolate, Mars] = Prism[Chocolate, Mars](
    getOption = {
      case mars: Mars => Some(mars)
      case _ => None
    },
    reverseGet = identity
  )

  val SnickersPrism: Prism[Chocolate, Snickers] =
    Prism[Chocolate, Snickers](
      getOption = {
        case snickers: Snickers => Some(snickers)
        case _ => None
      },
      reverseGet = identity
    )

  val BountyPrism: Prism[Chocolate, Bounty] =
    Prism.partial[Chocolate, Bounty] {
      case bounty: Bounty => bounty
    }(identity)

  val BountyIso: Iso[Bounty, Int] = Iso[Bounty, Int](_.coconutMass, Bounty)


  val ChocolateBarPrism: Prism[Chocolate, ChocolateBar] =
    Prism.partial[Chocolate, ChocolateBar] {
      case bar: ChocolateBar => bar
    }(identity)

  val MilkaPrism: Prism[ChocolateBar, Milka] =
    Prism.partial[ChocolateBar, Milka] {
      case milka: Milka => milka
    }(identity)

}


