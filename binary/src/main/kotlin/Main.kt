/*
 author: Justin Law
 class: EN.605.204.81
 module: 01 - Binary Numbering Formats
*/

// this is the main executable that allows the user to choose what program to run
// the programs are identified in the individual class files and in the in-line comments

fun main(args: Array<String>) {
  println("\nWelcome to the Binary Representation Function Library!\n")
  val converter = BinaryToHexConverter(UserInputHandler())
  val result = converter.convert()
  println(result)
}
