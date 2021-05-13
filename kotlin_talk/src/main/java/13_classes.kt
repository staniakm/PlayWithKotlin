import java.time.LocalDate

fun main() {
    //classes are final by default
    val person1 = KPerson("Jan", "Nowak", LocalDate.of(2019, 1, 1))
    val person2 = KPerson("Jan", "Nowak", LocalDate.of(2019, 1, 1))

    println("are equal ? ${person1.equals(person2)}")


    println(person1.weight)
    person1.weight = -1
    person1.weight = 59
    println(person1.weight)
    println(person1.name)
    println(person1.fullName)
    println("age = ${person1.age}")

    val p2 = KPerson("Jan", "Nowak", LocalDate.of(2019, 1, 1), "Jackobs")
}


//class XPerson: KPerson("Jan", "Nowak", LocalDate.of(2019, 1, 1)){
//    override fun fullName(): String {
//        return super.fullName()
//    }
//}

open class KPerson(private val _name: String, val surname: String, val dateOfBirth: LocalDate) {

    constructor(_name: String, surname: String, dateOfBirth: LocalDate, familyName: String) : this(
        _name,
        surname,
        dateOfBirth
    ) {
        this.familyName = familyName
    }

    var familyName: String = ""

    var age: Int = 1
        private set
        get() = LocalDate.now().year - (dateOfBirth.year)

    fun fullName() = "$name $surname"

    val fullName
        get() = "$name $surname"

    var weight: Int = 50
        set(value) {
            field = if (value < 0) {
                println("Unable to set weight below 0")
                50
            } else {
                value
            }
        }

    val name: String = _name
        get() = field.toUpperCase()
}
