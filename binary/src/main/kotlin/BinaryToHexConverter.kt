import kotlin.math.pow

/*
  this class contains the functions required to complete the following:
  - take in a binary string and check whether its format is correct
  - account for unsigned decimal integers of reasonable varying size
  - convert the binary string to an unsigned decimal integer
  - convert an unsigned decimal integer to the hexadecimal string
  - provide rudimentary error handling
*/

class BinaryToHexConverter() {
  private val hexadecimal = "0123456789ABCDEF"

  fun start(): String {
    val binaryString = UserInputHandler().getUserStringInput("Enter a binary string: ", this::checkBinaryString)
    val decimal = binaryToDecimal(binaryString)
    return decimalToHexadecimal(decimal)
  }

  // checks to see if the binary string is valid
  // uses the all method which checks all elements in the string using the lambda function
  private fun checkBinaryString(input: String): Boolean = input.all { it == '0' || it == '1' }

  // converts an unsigned decimal integer to a hexadecimal representation
  private fun decimalToHexadecimal(decimal: Int): String {
    var decimal = decimal
    // String builder class to keep track of the hexadecimal representation
    val hex = StringBuilder()

    // Repeat the division by 16 and remainder calculation until the decimal integer is 0
    while (decimal > 0) {
      val remainder = decimal % 16
      hex.append(this.hexadecimal[remainder])
      decimal /= 16
    }

    // convert to a reversed string for the proper hexadecimal representation
    return hex.reverse().toString()
  }

  // converts a binary string to an unsigned decimal integer
  private fun binaryToDecimal(binary: String): Int {
    var total = 0
    // loop through the binary string in reverse order (right to left)
    for (i in binary.length - 1 downTo 0) {
      // add the corresponding power of 2 to the total
      if (binary[i] == '1') {
        total += 2.0.pow((binary.length - i - 1).toDouble()).toInt()
      }
    }
    return total
  }

}