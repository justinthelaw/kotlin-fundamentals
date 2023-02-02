/*
  this class contains the functions required to complete the following:
  - request the user choose lower or uppercase conversion
  - take in a string of any capitalization(s), string only contains alphabetical characters, else program ignores it
  - convert the string's characters to the upper or lower case
  - provide rudimentary error handling
*/

class CaseConverter() {

  // decides upon lower case or upper case transform
  fun start(): String {
    val functionOne = "toLowerCase"
    val functionTwo = "toUpperCase"

    // map the typed number to the choice
    val choiceMap: Map<String, String> = mapOf(
      "1" to functionOne,
      "2" to functionTwo,
      "3" to "Exit"
    )

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
    var result: String = when (userChoice) {
      "1" -> {
        func()
        val string = inputHandler.getUserStringInput("Enter a string to decapitalize: ")
        toLowerCase(string)
      }

      "2" -> {
        func()
        val string = inputHandler.getUserStringInput("Enter a string to capitalize: ")
        toUpperCase(string)
      }

      else -> "You chose to exit the program."
    }

    return result
  }

  /*
    converts string characters to lower case form using the following:
    - the 0b100000 constant
    - the "OR" bitwise operator
  */
  private fun toLowerCase(string: String): String {
    return string.map { char ->
      // check to see if character is alphabetic and upper case
      if (char in 'A' .. 'Z') {
        // use bitwise operation on the binary (base2) value of the character
        (char.code or 0b100000).toChar()
      } else {
        // else, just return lower case character, or non-alphabetic character
        char
      }
    }.joinToString("") // collapse characters into string
  }

  /*
    converts string characters to upper case form using the following:
    - the 0b100000 constant
    - the "XOR" bitwise operator
  */
  private fun toUpperCase(string: String): String {
    return string.map { char ->
      // check to see if character is alphabetic and lower case
      if (char in 'a' .. 'z') {
        // use bitwise operation on the binary (base2) value of the character
        (char.code xor 0b100000).toChar()
      } else {
        // else, just return upper case character, or non-alphabetic character
        char
      }
    }.joinToString("") // collapse characters into string
  }
}