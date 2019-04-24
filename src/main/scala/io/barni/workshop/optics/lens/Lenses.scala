package io.barni.workshop.optics.lens

object Lenses {

  import Models._

  val PersonAddressLens: Lens[Person, Address] = Lens[Person, Address](
    get = _.address,
    set = (person, address) => person.copy(address = address)
  )

  val AddressStreetLens: Lens[Address, Street] = Lens[Address, Street](
    get = _.street,
    set = (address, street) => address.copy(street = street)
  )

  val StreetNameLens: Lens[Street, String] = Lens[Street, String](
    get = _.name,
    set = (street, name) => street.copy(name = name)
  )

  val StreetTypeLens: Lens[Street, String] = Lens[Street, String](
    get = _.`type`,
    set = (street, `type`) => street.copy(`type` = `type`)
  )


}
