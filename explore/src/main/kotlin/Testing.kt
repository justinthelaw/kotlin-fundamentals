import junit.framework.TestCase.assertEquals
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import java.util.Calendar


class AgeCalculation() {
  fun getAge(date: Calendar): Int {

    val today = Calendar.getInstance()

    if (date.timeInMillis > today.timeInMillis) {
      throw IllegalArgumentException("You can't be born past today's date!")
    }


    val years = today.get(Calendar.YEAR) - date.get(Calendar.YEAR)
    return if (date.get(Calendar.DAY_OF_YEAR) > today.get(Calendar.DAY_OF_YEAR)) {
      years - 1
    } else {
      years
    }
  }
}

class AgeCalculationTests() {
  @Test
  fun checkAgeWhenBornToday() {
    assertEquals(0, AgeCalculation().getAge(Calendar.getInstance()))
  }

  @Test
  fun checkAgeWhenBorn1000DaysAgo() {
    val date = Calendar.getInstance()
    date.add(Calendar.DAY_OF_YEAR, -1000)

    assertEquals(2, AgeCalculation().getAge(date))
  }

  @Test
  fun testForException() {
    val date = Calendar.getInstance()
    date.add(Calendar.DAY_OF_YEAR, 1)

    Assertions.assertThrows(IllegalArgumentException::class.java) {
      AgeCalculation().getAge(date)
    }
  }
}