// this class contains the functions required to complete the following:
// - take in a binary string and check whether its format is correct
// - account for unsigned decimal integers of reasonable varying size
// - convert the binary string to a hexadecimal string
// - rudimentary error handling

class CaseConverter(private val inputHandler: UserInputHandler) {

  // decides upon lower case or upper case transform
  fun convert(): String {
    val functionOne = "toLowerCase"
    val functionTwo = "toUpperCase"

    // map the typed number to the choice
    val choiceMap: Map<String, String> = mapOf(
      "1" to functionOne,
      "2" to functionTwo,
      "3" to "Exit"
    )

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
    return when (userChoice) {
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
  }

  // converts string characters to lower case form
  private fun toLowerCase(string: String): String {
    return string
  }

  // converts string characters to upper case form
  private fun toUpperCase(string: String): String {
    return string
  }
}