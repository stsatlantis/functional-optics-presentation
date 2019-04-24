package io.barni.workshop.optics.iso

object Units {

  final case class CentiMeter(value: Double) extends AnyVal // base unit
  final case class Meter(value: Double) extends AnyVal // 100 cm
  final case class Inch(value: Double) extends AnyVal // 2.54 cm
  final case class Foot(value: Double) extends AnyVal // 12 inch

  final case class Kilogram(value: Double) extends AnyVal // base unit
  final case class Gram(value: Double) extends AnyVal // 0.001 kg
  final case class Pound(value: Double) extends AnyVal // 0.45359237 kg

  object syntax {

    implicit class LengthOps(private val self: Double) extends AnyVal {

      def cm = CentiMeter(self) //
      def m = Meter(self) //
      def inch = Inch(self) //
      def foot = Foot(self) //
      def feet = Foot(self) //

    }

    implicit class WeightOps(private val self: Double) extends AnyVal {

      def kg = Kilogram(self) //
      def g = Gram(self) //
      def pound = Pound(self) //
    }


  }

}
