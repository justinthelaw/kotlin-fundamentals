/*
  this class contains the functions required to complete the following:
  - request user input
  - run the provided or default check on the user's input
  - return the user input as the result or provide rudimentary error handling
*/

import java.lang.IllegalArgumentException
import handleError

class UserInputHandler {
  private lateinit var choices: Set<String>

  // method for getting user input in the terminal,
  // with an argument for a lambda function for checking the input
  // if no check is provided, default lambda is provided
  fun getUserStringInput(request: String, check: (String) -> Boolean = this::defaultStringInputCheck): String {
    var result = ""
    // try-catch block for error handling
    try {
      // ask for user input in terminal
      println("$request")
      result = readln()
      // run the lambda function check
      if (!check(result)) {
        throw IllegalArgumentException("You entered an incorrectly formatted input.")
      }
    } catch (e: Exception) {
      handleError("Input Error:", e)
    }
    return result
  }

  // provides function for setting pre-defined choices for a multiple choice check
  fun setChoices(arrayOfChoices: Set<String>) {
    this.choices = arrayOfChoices
  }

  // provides checking based on pre-defined choices that the user must pick from
  fun multipleChoiceChecker(input: String): Boolean = choices.contains(input)

  // provides a default check for handling user string input
  private fun defaultStringInputCheck(input: String): Boolean = input.isNotBlank()


}