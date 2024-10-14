object FunctionalProgramming extends App {

  // scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // invoking bob as a function

  val simpleIncrementer = new Function[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23) // 24
  simpleIncrementer(23)
  // defined a function

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatenator("I love", " Scala")

  // alternative syntax
  val doubler: Function[Int, Int] = (x: Int) => 2*x
  val altDoubler: Int => Int = (x: Int) => 2*x
  val altAltDoubler = (x: Int) => 2*x

  // higher-order functions: take functions as args or return as results
  val aMappedList = List(1,2,3).map(x => x+1)
  println(aMappedList)
  val aFlatMappedList = List(1,2,3).flatMap {
    x => List(x, 2*x, 3*x)
  } // alternative syntax. same as .map(x => List(x, 2*x, 3*x))
  val aFilteredList = List(1,2,3,4,5).filter(_ <= 3) // equivalent to x => x <= 3

  // all pairs between numbers 1,2,3 and letters "a", "b", "c"
  val allPairs  = List(1,2,3).flatMap(x => List("a", "b", "c").map(_ + x))
  println(allPairs)

  // for comprehensions
  val alternativePairs = for {
    x <- List(1,2,3)
    y <- List("a", "b", "c")
  } yield y+x // equivalent to flat map :o

  // lists
  val aList = List(1,3,4,5,6)
  val firstElement = aList.head // first element
  val rest = aList.tail // elements without first without head
  val aPrependedList = 0 :: aList // 0 added at head position
  val anExtendedList = aList :+ 7 // 7 added at last element

  // sequences
  val aSequence: Seq[Int] = Seq(1,2,3) // Seq.apply(1,2,3)
  val accessedElement = aSequence(1) // element at index 1: 2

  // vectors: fast Seq implementation, same methods as Lists
  val aVector = Vector(1,2,3,4,5)

  // sets
  val aSet = Set(1,2,3,1) // (1,2,3)
  val setHas5 = aSet.contains(5) // false
  val anAddedSet = aSet + 5 // (1,2,3,5)
  val aRemovedSet = aSet - 3 // (1,2)

  // ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(2*_).toList // list of(2, 4, 6, ..., 2000)

  // tuples = groups of values under the same value
  val aTuple = ("Vkie", "Rap", 1)

  // maps
  val aPhoneBook: Map[String, Int] = Map(
    ("Daniel", 123),
    ("Jane" -> 1233))
}
