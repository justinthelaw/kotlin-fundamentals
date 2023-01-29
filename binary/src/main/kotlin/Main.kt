/*
 AUTHOR: Justin Law
 CLASS: EN.605.204.81
 MODULE: 01 - Binary Numbering Formats
 DESCRIPTION:
  - this is the main executable that allows the user to choose what program to run
  - the programs are identified in the individual class files and in the in-line comments
  - future TODO: modularize the multiple choice code that is duplicated in Main.kt and CaseConverter.kt
  - future TODO: create do-while loops to allow user to restart at input points or end conditions
*/


fun main(args: Array<String>) {
  println("\nHello! Welcome to Justin's Binary Representation Function Library.\n")
  /*
    1.	A program to implement the toUpper and toLower.
    To implement these functions, you must use the bitwise AND (&) and OR (|) operators.
    Using addition and subtraction is not acceptable for this assignment

    see ./CaseConverter.kt
  */
  val functionOne = "toLowerCase and toUpperCase Converter"
  /*
    2.	Write a program to take a string representing a binary number,
    and write out the number in hex.

    see ./BinaryToHexConverter.kt
  */
  val functionTwo = "Binary to Hexadecimal Converter"

  // map the typed number to the choice
  val choiceMap: Map<String, String> = mapOf(
    "1" to functionOne,
    "2" to functionTwo,
    "3" to "Exit"
  )
  // create a new user input handler
  val inputHandler = UserInputHandler()
  // use the predefined choices to form request string for user input
  val choices = choiceMap.keys
  inputHandler.setChoices(choices)
  var request = "Type the number of the function you would like to use:"
  for (choice in choices) {
    request += "\n($choice) ${choiceMap[choice]}"
  }
  // take-in input using the multiple choice check from the user input handler
  val userChoice = inputHandler.getUserStringInput(request, inputHandler::multipleChoiceChecker)

  // tell the user what the function they chose was
  val func: () -> Unit = { println("Executing " + choiceMap[userChoice] + "...") }

  // execute the user's chosen function
  when (userChoice) {
    "1" -> {
      func()
      val result = CaseConverter().start()
      println("Result: $result")
    }

    "2" -> {
      func()
      val result = BinaryToHexConverter().start()
      println("Result: $result")
    }

    else -> println("You chose to exit the program.")
  }

  println("\nThank you for using Justin's Binary Representation Function Library. Goodbye!")

}
