import kotlin.math.*

fun main (args: Array<String>) {
  val radius: Double = args[0].toDouble()
  val message: String = "The area of a circle of radius ${radius} units is..."
  println(message)

  val area: Double = PI * radius.pow(2)
  println("%.2f".format(area) + " units^2")
}