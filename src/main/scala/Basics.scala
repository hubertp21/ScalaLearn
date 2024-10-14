object Basics extends App {
  // defining value
  val number: Int = 23 // const/final int

  val booleanType = false // optional type

  val aString = "I learn Scala :o" // another optional type
  val aComposedString = "I" + " " + "learn" + " " + "Scala"
  val aInterpolatedString = s"I am $number"

  // expressions
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (number > 23) 10 else 100
  val chainedIfExpression =
    if (number > 23) 10
    else if (number < 0) 1
    else if (number > 1000) 1000
    else 100 // :o

  // code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67
    // value of block is the value of the last expression
    aLocalValue + 2
  }

  // defining a function
  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  // recursive functions
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  // Unit type = no meaningful value == void
  println("Unit type")
  val unit: Unit = ()
  def unitReturningFunction(): Unit =
    println("Returning unit type")
}
