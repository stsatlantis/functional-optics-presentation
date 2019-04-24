package io.barni.workshop.optics.iso

object Converters {

  import Units._

  val MeterCentiMeterIso: Iso[Meter, CentiMeter] =
    Iso[Meter, CentiMeter](meter => CentiMeter(meter.value * 100), centi => Meter(centi.value / 100))

  val CentiMeterInchIso: Iso[CentiMeter, Inch] =
    Iso[CentiMeter, Inch](centi => Inch(centi.value / 2.54d), inch => CentiMeter(inch.value * 2.54d))

  val InchFootIso: Iso[Inch, Foot] =
    Iso[Inch, Foot](inch => Foot(inch.value * 12), foot => Inch(foot.value / 12))

  val KilogramGramIso: Iso[Kilogram, Gram] =
    Iso[Kilogram, Gram](kilo => Gram(kilo.value * 1000), gram => Kilogram(gram.value / 1000))

  val KiloPoundIso: Iso[Kilogram, Pound] =
    Iso[Kilogram, Pound](kilo => Pound(kilo.value * 0.45359237), pound => Kilogram(pound.value / 0.45359237))

}
