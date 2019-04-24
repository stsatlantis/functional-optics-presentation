package io.barni.workshop.optics.prism

import org.scalatest.{Matchers, WordSpec}
import scala.language.postfixOps

class MilkaSpec extends WordSpec with Matchers{

  import ChocolateOptics._
  import Chocolate._

  val `110%`: Int => Int = _ * 1.1 toInt


  //case class Sajt(name: String, age: Int) - (String, Int)

  "Milka" when {
    "there is a promotion" should {
      "be 10 percent more" in {
        val increaseMilkaWeight: Milka => Milka = milka => milka.copy(weight = `110%` (milka.weight))
        val `10 percent more milka` = ChocolateBarPrism compose MilkaPrism modify increaseMilkaWeight
        val `10 percent more milka Option` = ChocolateBarPrism compose MilkaPrism modifyOption increaseMilkaWeight

        val chocolates: List[Chocolate] = List(Bounty(12), Snickers("salty", 12), Milka(100), Milka(200))

        chocolates.map(`10 percent more milka`) shouldBe List(Bounty(12), Snickers("salty", 12), Milka(110), Milka(220))
        chocolates.map(`10 percent more milka Option`) shouldBe List(None, None, Some(Milka(110)), Some(Milka(220)))
        chocolates.flatMap(x => `10 percent more milka Option`(x)) shouldBe List(Milka(110), Milka(220))

      }

    }
  }

}
