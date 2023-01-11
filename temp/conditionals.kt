fun main(args: Array<String>) {
  val a: Int = args[0].toInt()
  val b: Int = args[1].toInt()

  var max = if (a > b) a else b
  println("The larger variable is... ${max}")
}