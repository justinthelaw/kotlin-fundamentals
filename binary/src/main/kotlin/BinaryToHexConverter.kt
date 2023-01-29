/*
  this class contains the functions required to complete the following:
  - take in a binary string and check whether its format is correct
  - account for unsigned decimal integers of reasonable varying size
  - convert the binary string to a hexadecimal string
  - provide rudimentary error handling
*/

class BinaryToHexConverter(private val inputHandler: UserInputHandler) {
  fun convert(): String {
    val binaryString = inputHandler.getUserStringInput("Enter a binary string: ")
    return binaryString
  }
}