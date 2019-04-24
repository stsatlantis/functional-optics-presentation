package io.barni.workshop.optics.iso

import org.scalatest.{Matchers, WordSpec}

import scala.language.postfixOps

class MeasureSpec extends WordSpec with Matchers {

  import Converters.{CentiMeterInchIso, InchFootIso, KiloPoundIso, MeterCentiMeterIso}
  import Measure.calculateBMI
  import Units.syntax._

  "BMI" should {
    "work" when {
      "inputs are in cm and kg" in {
        val weight = 80 kg // Kilogram(80)
        val height = 180 cm

        val heightInMeter = MeterCentiMeterIso.reverseGet(height)
        calculateBMI(heightInMeter, weight)

      }

      "inputs are in m and pounds" in {
        val weight = 190 pound
        val height = 1.8 m

        calculateBMI(height, KiloPoundIso.reverseGet(weight))

      }

      "inputs are in feet and pounds" in {
        val weight = 190 pound
        val height = 5 feet

        val meterFeetIso: Iso[Units.Meter, Units.Foot] = MeterCentiMeterIso compose CentiMeterInchIso compose InchFootIso
        val asd = InchFootIso.reverse compose CentiMeterInchIso.reverse compose MeterCentiMeterIso.reverse

        calculateBMI(meterFeetIso.reverseGet(height), KiloPoundIso.reverseGet(weight))
        calculateBMI(asd.get(height), KiloPoundIso.reverseGet(weight))
        val `1 m` = 1 m

        val meterInchIso = meterFeetIso compose InchFootIso.reverse
        (meterInchIso get `1 m`) shouldBe (39.37007874015748 inch)
      }

    }

    "modify" when {
      "CentiMeter is modified" in {
        val lengthInCm = 10 cm

        val doubler: Units.CentiMeter => Units.CentiMeter = MeterCentiMeterIso.modify(x => (x.value * 2) m)

        doubler(lengthInCm) shouldBe (20 cm)

      }


    }

  }

}
