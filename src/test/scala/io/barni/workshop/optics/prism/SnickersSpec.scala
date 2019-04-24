package io.barni.workshop.optics.prism

import org.scalatest.{Matchers, WordSpec}
import scala.language.postfixOps

class SnickersSpec extends WordSpec with Matchers {

  import ChocolateOptics._
  import Chocolate._

  val `110%`: Int => Int = _ * 1.1 toInt

  "Snickers" when {
    "business requires 10% more peanuts" should {
      "contain 10 percent more peanuts - naive" in {

        val snickers: Chocolate = Snickers("sweet", 10)

        val `10% more peanuts` = SnickersPrism.modify(s => s.copy(nrOfPeanuts = `110%`(s.nrOfPeanuts)))

        `10% more peanuts`(snickers) shouldBe Snickers("sweet", 11)
      }
    }
  }

}
