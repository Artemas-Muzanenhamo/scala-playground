package com.artemas

class ScalaCollections {
  // Collection categories = Sequences, Sets, Maps
  // Sequences - Arrays, Lists

  // List - Immutable by default

  //invariance vs covariance - Lists can be subtypes of other lists AnimalBox[Cat] -> AnimalBox[Animal]
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

  // Creating and Populating Lists
  private val value: List[Nothing] = List()
  private val anyValues: List[Any] = List(1, 2, "demo", List())

  // Cons = Constructs an object from a pair of values
  // In many FP languages the :: operator implements the cons operation
  // The :: Nil allows the compiler to get the correct type inference to create a List
  private val colours: List[String] = "red" :: "orange" :: "blue" :: Nil

  /**
   * Nil - The empty list
   * Nil extends List - :: is a def on List
   * a :: Nil - Infix form
   * N.::(a) - Long hand form
   *
   * a.::(Nil) does not work because :: is right associative
   *
   */

  // Travesal
  val numbers = List(1, 2, 3, 4, 5, 6)
  // foreach
  numbers.foreach(print(_))

  // iterator
  val iter = numbers.iterator
  while (iter.hasNext) print(iter.next())

  // for loop - Scala uses Generator Based For Loops
  // any iterator can be used as a generator
  // under the hood Scala will use the foreach()
  // All collections have a foreach()
  for (element <- numbers) {
    print(element)
  }

  // Sets
  // Maps
}
