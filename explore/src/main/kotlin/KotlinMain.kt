import java.util.GregorianCalendar

fun main() {
  val justin = KotlinPerson(1L, "Mr.", "Justin", "Law", GregorianCalendar(1997, 2, 19))
  val meaghan = KotlinPerson(2L, "Ms.", "Meaghan", "FitzGerald", GregorianCalendar(1999, 7, 25))

  println(justin.toString() + "'s age is " + justin.getAge())
  println(meaghan.toString() + "'s age is " + meaghan.getAge())
  println(justin.toString() + "'s hash is " + justin.hashCode())
  println(meaghan.toString() + "'s hash is " + meaghan.hashCode())
  println("The age of someone born on the 3rd of May 1988 is " + KotlinPerson.getAge(GregorianCalendar(1988, 5, 3)))

  val fakeJustin = KotlinPerson(3L, "Mr.", "Justin", "Law", GregorianCalendar(1997, 2, 19))
  println("\nIs there a fake Justin? ${!justin.equals(fakeJustin)}")
}
