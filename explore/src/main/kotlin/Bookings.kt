import java.math.BigDecimal

interface BookingManager {

  val version: String

  fun isSeatFree(seat: Seat): Boolean
  fun reserveSeat(seat: Seat, customerID: Long): Boolean

  fun systemStatus() = "All Operations Are Functional"
}

class UnauthorizedUserException: Throwable()

open class BasicBookingManager(authorizationKey: String) : BookingManager {

  override val version = "1.0"

  override fun isSeatFree(seat: Seat) = true
  override fun reserveSeat(seat: Seat, customerID: Long) = false

  init {
    if (authorizationKey != "12345") throw UnauthorizedUserException()
  }

}

class AdvancedBookingManager : BasicBookingManager("12345"), java.io.Closeable {

  override val version = "2.0"

  fun howManyBookings() = 10

  override fun close() {}

}

// in this file and package, all Strings now have extended function for basic String class
fun String.toSentenceCase (): String {
  return this[0].uppercaseChar() + this.substring(1)
}

fun main(args: Array<String>) {
  val booking = AdvancedBookingManager().isSeatFree(Seat(1, 1, BigDecimal(0), ""))
  println(booking)

  val greeting = "welcome!"
  println(greeting.toSentenceCase())

}