package com.artemas

class ScalaCollections {
  // Collection categories = Sequences, Sets, Maps
  // Sequences - Arrays, Lists

  // List - Immutable by default, covariance

  class AnimalBox[A](var content: A) // This is an invariant type
  abstract class Animal {
    def name: String
  }

  case class Cat(name: String) extends Animal
  case class Dog(name: String) extends Animal

  val myCatBox: AnimalBox[Cat] = AnimalBox[Cat](Cat("Felix"))
  val myAnimalBox: AnimalBox[Animal] = myCatBox // this doesn't compile
  val myAnimal: Animal = myAnimalBox.content

  class ImmutableBox[+A](val content: A) // This is a covariant type

  val catbox: ImmutableBox[Cat] = ImmutableBox[Cat](Cat("Felix"))
  val animalBox: ImmutableBox[Animal] = catbox // now this compiles

  // Sets
  // Maps
}
