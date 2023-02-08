import java.util.*

data class KotlinPerson(
  val id: Long,
  val title: String,
  val firstName: String,
  val lastName: String,
  val dateOfBirth: Calendar
) {

  @Override
  override fun toString(): String {
    return "${this.title} ${this.firstName} ${this.lastName}"
  }

  companion object {
    fun getAge(dateOfBirth: Calendar): Int {
      val today = GregorianCalendar()
      return today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR)
    }
  }

  fun getAge(): Int {
    return Companion.getAge(this.dateOfBirth)
  }

  @Override
  fun equals(other: KotlinPerson): Boolean {
    if (this == other) {
      return true
    } else if (this::class != other::class) {
      return false
    }
    return this.id == other.id &&
      this.title == other.title &&
      this.firstName == other.firstName &&
      this.lastName == other.lastName &&
      this.dateOfBirth == this.dateOfBirth
  }

  @Override
  override fun hashCode(): Int {
    return Objects.hash(this.id, this.title, this.firstName, this.lastName, this.dateOfBirth)
  }

}
