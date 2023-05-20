package com.artemas

class ObjectOrientation extends App {
  // Scala is an OO language

  // class and instance
  class Animal {
    // define fields
    val age: Int = 0
    // define methods
    def eat() = println("I'm eating")
  }
  // use of keyword 'new' like C++ or Java
  val anAnimal = new Animal

  // inheritance
  class Dog(val name: String) extends Animal {} // constructor definition
  val aDog = new Dog("Lassie")

  // constructor arguments are NOT fields
  // you need to put a val before the constructor argument
  aDog.name

  // subtye polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // fields + methods are by default public, can restrict by using private or protected
    def walk(): Unit
  }

  // "interface" = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method
  }

  // single-class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher:
    override def eat(animal: Animal): Unit = println("I am eating you, animal!")
    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = object method argument, only available for methods with ONE argument
  aCroc ?! "What if we could fly?"

  // operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2)

  // anonymous classes
  val dinosaur = new Carnivore:
    override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat anything!")

  /**
   * What you tell the compiler:
   *
   * class Carnivore_Anonymous_12343 extends Carnivore {
   *  override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat anything!")
   * }
   *
   * val dinosaur = new Carnivore_Anonymous_12343
   */

  // singleton object
  object MySingleton { // the only instance of the MySingleton type
    val mySpecialValue = 672342
    def mySpecialMethod(): Int = 23424
    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent to MySingleton.apply

  object Animal { // companion - companion object i.e. Animal Class vs Animal Object
    // companions can access each other's private fields/methods
    // singleton Animal and instances of Animal are different things
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods

  // case classes = lightweight data structures with some boilerplate
  // sensible equals and hash code
  // serialization
  // companion with apply
  case class Person(name: String, age: Int)

  // may be constructed without the 'new' keyword
  val bob = Person("Bob", 54) // Person.apply("Bob", 54) - via pattern matching

  // exceptions
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch {
    case e: Exception => "some faulty error message"
  } finally {
    // execute some code no matter what
  }

  // generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }
}
