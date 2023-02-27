import java.io.FileInputStream
import java.lang.Exception

// Throws helps Java code being integrated so that exceptions must be handled by user
@Throws (InterruptedException::class)
fun divide(a: Int, b: Int): Double {
  Thread.sleep(1000)
  if (b == 0) {
    throw ArithmeticException()
  } // can also just not convert b to a double
  return (a.toDouble() / b.toDouble())
}

// similar with try with resources from Java
fun printFile(file: String) {
  val input = FileInputStream(file)
  input.use {
    //an exception could be throw in here
  }
}

fun main (args: Array<String>) {

  try {
    println(divide(7, 0))
  } catch (e: ArithmeticException) {
    println("1 - can't divide by 0")
  } catch (e: InterruptedException) {
    println("1 - interrupted")
  }

  var result = try {
    divide(5, 23)
  } catch (e: Exception) {
    println("2 - $e")
  }

  println("2 - $result")

}