package io.barni.workshop.optics.prism

import org.scalatest.{Matchers, WordSpec}
import scala.language.postfixOps

class BountySpec extends WordSpec with Matchers {

  import ChocolateOptics._
  import Chocolate._

  val `110%`: Int => Int = _ * 1.1 toInt


  "Bounty" should {
    "be created by only referencing the mass of the coconut it contains" in {
      val ChocolateIntPrism = BountyPrism.compose(BountyIso)
      val bountyCreator = ChocolateIntPrism.reverseGet
      val bountyModifier = ChocolateIntPrism.modify(_ + 1)
      val bountyMass = 123


      bountyCreator(bountyMass) shouldBe Bounty(123)
      bountyModifier(Bounty(123)) shouldBe Bounty(124)
    }
  }


}
