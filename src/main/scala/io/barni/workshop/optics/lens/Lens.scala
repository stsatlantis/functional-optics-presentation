package io.barni.workshop.optics.lens

// Laws
// set(a,get(a)) = a
// get(set(a,b)) = b

case class Lens[A, B](get: A => B, set: (A, B) => A) {

  def compose[C](other: Lens[B, C]): Lens[A, C] = Lens(get andThen other.get, (a, c) => set(a, other.set(get(a), c)))

  def modify(f: B => B): A => A = a => set(a, (get andThen f)(a) )

}


object Lens {

  def at[Key, Value](key: Key): Lens[Map[Key, Value], Option[Value]] =
    Lens[Map[Key, Value], Option[Value]](m => m get key,
      (map, optionalValue) =>
        optionalValue match {
          case None => map - key
          case Some(value) => map + (key -> value)
        }
    )

}


