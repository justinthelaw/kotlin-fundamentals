fun main(args: Array<String>) {
  println("\nWelcome to the Binary Representation Function Library!\n")
  val converter = BinaryToHexConverter(UserInputHandler())
  val result = converter.convert()
  println(result)
}
