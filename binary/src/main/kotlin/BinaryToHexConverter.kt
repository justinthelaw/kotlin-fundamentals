class BinaryToHexConverter (private val inputHandler: UserInputHandler) {
    fun convert(): String {
        return inputHandler.getUserStringInput("Binary String")
    }
}