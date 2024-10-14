object ObjectOrientation extends App {

  // class and instance
  class Animal {
    // define fields
    val age: Int = 0

    // define methods
    def eat(): Unit = println("I am eating")
  }

  val anAnimal = new Animal

  // inheritance
  class Dog(val name: String) extends Animal // constructor definition

  val aDog = new Dog("Lassie")

  // constructor arguments ARE NOT FIELDS
  aDog.name // need to put "val" before constructor arg

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Doggy")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // all fields and methods are by default public
    def walk(): Unit
  }

  // "interface" = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method name :o
  }

  // single class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am crushing your skull")
    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation, only for methods with ONE argument
  aCroc ?! "Nothing clever"

  // operators in Scala are methods :o
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2)

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println ("I am a dinosaur ? ?")
  }
  /*
    class Carnivore_Anonymous_492849 extends Carnivore smth like that
  */

  // singleton object
  object MySingleton { // the only instance of the MySingleton type
    val mySpecialValue = 12414
    def mySpecialMethod(): Int = 214214
    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent

  object Animal { // companions - companion object - same name
    // companions can access each other's private fields/methods
    // singleton Animal and Instances of Animal are different things
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods

  /*
    case classes = lightweight data structures with some boilerplate
    - sensible equals and hash code
    - serialization
    - companion with apply
  */
  case class Person(name: String, age: Int)

  val bob = new Person("Bob", 54)
  val ann = Person("Ann", 45) // may be constructed without new

  // exceptions
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch {
    case e: Exception => "Some error message"
  } finally {
    // execute code no matter what
  }

  // generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  // using generic with a concrete type
  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head
  val rest = aList.tail
  
  // in scala we operate on immutable values
  val reversedList = aList.reverse
}
