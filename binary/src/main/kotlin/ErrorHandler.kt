/*
  this function contains the functions required to complete the following:
  - take in an exception and return a printed error in context
*/

// handles thrown exceptions
fun handleError(context: String, e: Exception) {
  println("$context: $e")
  print("${e.stackTrace}")
}
