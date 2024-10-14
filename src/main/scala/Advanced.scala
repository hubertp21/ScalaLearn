import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.*

object Advanced extends App {

  // lazy evaluation
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so lazy")
    43
  }
  val valueWithoutSideEffect = {
    println("I am not so lazy")
    43
  }
  val eagerValue = lazyValueWithSideEffect + 1
  // useful in infinite collections

  // pseudo collections: Option, Try
  def methodWhichCanReturnNull(): String = "Hello Scala"

  // Some(value) or None - valid type
  val anOption = Option(methodWhichCanReturnNull()) // Some("Hello Scala")

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string $string"
    case None => "I obtained nothing :("
  }

  def methodWhichCanThrowAnException(): String = throw new RuntimeException

  // a value if code went well or exception :o
  val aTry = Try(methodWhichCanThrowAnException())

  val anotherStringProcessing = aTry match {
    case Success(value) => s"Everything went fine: $value"
    case Failure(exception) => s"Exception !11: $exception"
  }

  // asynchronous programming
  val aFuture = Future { // Future.apply()
    println("Loading...")
    Thread.sleep(1000)
    println("Value computed")
    67
  } // Future is a "collection: which contains a value then its evaluated
  // these types are monads\\

  // implicits
  // #1 implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val aImplicitInt: Int = 2488
  println(aMethodWithImplicitArgs)

  // implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(23.isEven())
}
