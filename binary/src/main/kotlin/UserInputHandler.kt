import java.lang.IllegalArgumentException
import kotlin.reflect.KProperty0

// a class specifically designed to handle user input
class UserInputHandler {
  private lateinit var choices: Set<String>

  // method for getting user input if input is a string
  fun getUserStringInput(request: String, check: (String) -> Boolean = this::defaultStringInputCheck): String {
    var result = ""
    try {
      println("$request")
      result = readln()
      if (!check(result)) {
        throw IllegalArgumentException("You entered an incorrectly formatted input.")
      }
    } catch (e: Exception) {
      handleUserError(e)
    }
    return result
  }

  fun setChoices(arrayOfChoices: Set<String>) {
    this.choices = arrayOfChoices
  }

  // provides checking based on pre-defined choices that the user must pick from
  fun multipleChoiceChecker(input: String): Boolean = choices.contains(input)

  // handles thrown exceptions
  private fun handleUserError(e: Exception) {
    println("Input Error: $e")
  }

  // provides a default check for handling user string input
  private fun defaultStringInputCheck(input: String): Boolean = input.isNotBlank()


}