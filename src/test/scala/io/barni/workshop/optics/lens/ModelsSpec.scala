package io.barni.workshop.optics.lens

import org.scalatest.{FlatSpec, Matchers}

class ModelsSpec extends FlatSpec with Matchers {

  import Lenses._
  import Models._

  val PersonStreetLens: Lens[Person, Street] = PersonAddressLens compose AddressStreetLens
  val PersonStreetNameLens: Lens[Person, String] = PersonAddressLens compose AddressStreetLens compose StreetNameLens
  val PersonStreetTypeLens: Lens[Person, String] = PersonAddressLens compose AddressStreetLens compose StreetTypeLens

  "PersonAddressLens" should "set new address" in {
    val newAddress = Address(city = "Malaga", street = Street(name = "Victoria", `type` = "calle"))
    val bobby = Person(name = "Bob", age = 17, address = Address(city = "Malaga", street = Street(name = "Nueva", `type` = "calle")))

    val bob = Person(name = "Bob", age = 17, address = newAddress)
    PersonAddressLens.set(bobby, newAddress) shouldBe bob
  }

  "AddressStreetLens" should "set new street" in {
    val `Calle Nueva Address` = Address(city = "Malaga", street = Street(name = "Nueva", `type` = "calle"))
    val `Calle Victoria` = Street(name = "Victoria", `type` = "calle")

    val `Calle Victoria Address` = Address(city = "Malaga", street = `Calle Victoria`)
    AddressStreetLens.set(`Calle Nueva Address`, `Calle Victoria`) shouldBe `Calle Victoria Address`
  }

  "StreetNameLens" should "set new name" in {
    val `Calle Nueva` = Street(name = "Nueva", `type` = "calle")
    val Victoria = "Victoria"

    val `Calle Victoria` = Street(name = Victoria, `type` = "calle")
    StreetNameLens.set(`Calle Nueva`, Victoria) shouldBe `Calle Victoria`
  }

  "StreetTypeLens" should "set new type" in {
    val `Calle Nueva` = Street(name = "Nueva", `type` = "calle")
    val Camino = "camino"

    val `Camino Nueva` = Street(name = "Nueva", `type` = Camino)
    StreetTypeLens.set(`Calle Nueva`, Camino) shouldBe `Camino Nueva`
  }

  "PersonStreetLens" should "set new street" in {
    val bobby = Person(name = "Bob", age = 17, address = Address(city = "Malaga", street = Street(name = "Nueva", `type` = "calle")))
    val `Calle Victoria` = Street(name = "Victoria", `type` = "calle")

    val bob = Person(name = "Bob", age = 17, address = Address(city = "Malaga", street = `Calle Victoria`))
    PersonStreetLens.set(bobby, `Calle Victoria`) shouldBe bob
  }

  "PersonStreetNameLens" should "set new street name" in {
    val bobby = Person(name = "Bob", age = 17, address = Address(city = "Malaga", street = Street(name = "Nueva", `type` = "calle")))
    val Victoria = "Victoria"

    val bob = Person(name = "Bob", age = 17, address = Address(city = "Malaga", street = Street(name = Victoria, `type` = "calle")))
    PersonStreetNameLens.set(bobby, Victoria) shouldBe bob
  }

  "PersonStreetTypeLens" should "set new street type" in {
    val bobby = Person(name = "Bob", age = 17, address = Address(city = "Malaga", street = Street(name = "Nueva", `type` = "calle")))
    val Camino = "camino"

    val bob = Person(name = "Bob", age = 17, address = Address(city = "Malaga", street = Street(name = "Nueva", `type` = Camino)))
    PersonStreetTypeLens.set(bobby, Camino) shouldBe bob
  }

}
