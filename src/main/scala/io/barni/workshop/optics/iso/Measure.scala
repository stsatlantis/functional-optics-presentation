package io.barni.workshop.optics.iso


object Measure {

  import io.barni.workshop.optics.iso.Units._

  // Needs to be commented because along with value classes causes compile time errors
  // def calculateBMI(height: Double, weight: Double): Double = weight / (height * height)

  def calculateBMI(height: Meter, weight: Kilogram): Double = weight.value / (height.value * height.value)

}