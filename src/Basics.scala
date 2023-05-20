object Basics extends App {
  // defining a value
  val meaningOfLife: Int = 42

  // strings and string operations
  val aComposedString = "I" + "love" + "Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  // expressions = structures that can be reduced to a value
  // everything in Scala resolves to a value.
  // if-expression
  // code block expression
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999
  val chainedIfExpression =
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0

  // code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67

    // value of block is the value of the last expression
    aLocalValue + 3
  }

  // define a function
  def myFunction(x: Int, y: String): String = y + " " + x

  // recursive functions
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  // In Scala we don't use loops or iteration, we use RECURSION!

  // the UNIT type = No meaningful value
  // the UNIT type is the equivalent of 'void' in other languages
  // also known as the type of SIDE EFFECTS
  println("I love Scala") // System.out.println("I love Scala")

  def myUnitReturningFunction(): Unit = {
    println("I don't love returning UNIT")
  }

  val theUnit: Unit = ()

}
