package io.barni.workshop.optics.lens

object Models {

  case class Street(name: String, `type`: String)
  case class Address(city: String, street: Street)
  case class Person(name: String, age: Int, address: Address)

}

