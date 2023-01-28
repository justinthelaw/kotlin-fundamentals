import java.lang.IllegalArgumentException

// a class specifically designed to handle user input
class UserInputHandler {
  // method for getting user input if input is a string
  fun getUserStringInput(request: String, check: (String) -> Boolean = ::defaultStringInputCheck): String {
    var result = ""
    try {
      println("Enter $request: ")
      result = readln()
      if (!check(result)) {
        throw IllegalArgumentException("You entered an incorrectly formatted $request")
      }
    } catch (e: Exception) {
      handleUserError(e)
    }
    return result
  }

  // handles thrown exceptions
  private fun handleUserError(e: Exception) {
    println("Input Error: $e")
  }

  // provides a default check for handling user string input
  private fun defaultStringInputCheck(s: String): Boolean {
    return s.isNotBlank()
  }
}