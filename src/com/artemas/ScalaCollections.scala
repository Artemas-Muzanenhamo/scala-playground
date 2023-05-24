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

  // Traversal
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

  // Two options to take collections apart we have 2 options:
  // Pattern matching
  // Match expressions = similar to 'switch' expressions in other languages
  /**
   * value match {
   *  case pattern guard => expression
   *  case ...
   *  case _ => default
   * }
   */

  // Extractor Patterns
  val names = List("Kobe", "LeBron", "Michael", "Magic")
  names match {
    case List("Michael", _, _) => println("found Michael")
    case List(_, "Kobe", _*) => println("found Kobe")
    case _ => println("Something")
  }


  // Constructor Patterns
  case class Person(name: String, age: Int)

  val person = Person("Dale", 21)
  person match
    case Person("Date", _) => println("found Person: Dale")
    case Person(_, 21) => println("found Age: 21")
    case Person("Bob", 21) => println("found Bob, 21")

  // Head and Tail

  // Sets
  private val setExample: Set[Int] = Set(1, 2, 3, 3, 4, 5, 5, 6, 7, 8)

  // Maps
  private val namesAndAge: Map[String, Int] = Map("Kobe" -> 40, "LeBron" -> 38)
  private val kobeAge: Int = namesAndAge.getOrElse("Kobe", 0)
}
