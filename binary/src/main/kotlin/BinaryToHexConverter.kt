// this class contains the functions required to:
// - take in a binary string and check whether its format is correct
// - account for unsigned decimal integers of reasonable varying size
// 2. Take the

class BinaryToHexConverter(private val inputHandler: UserInputHandler) {
  fun convert(): String {
    return inputHandler.getUserStringInput("a binary string")
  }
}