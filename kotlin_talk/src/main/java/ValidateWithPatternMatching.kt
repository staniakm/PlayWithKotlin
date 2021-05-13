import validators.AgeValidator
import validators.NameValidator
import validators.SurnameValidator as surname

fun main() {

    val p = KotlinPerson("Ja", "Kowalski", 117)
    val result = Validators().validate(p)
    println(result)

}

sealed class ValidationResult {
    object Success : ValidationResult()
    data class Failure(val message: String) : ValidationResult()
}

data class KotlinPerson(val name: String, val surname: String, val age: Int)

class Validators {
    private val validators = listOf(NameValidator(), surname(), AgeValidator())
    fun validate(p: KotlinPerson?): ValidationResult {
        validators.forEach {
            when (val result = it.validate(p)) {
                is ValidationResult.Failure -> return result
                is ValidationResult.Success -> return@forEach
            }
        }
        return ValidationResult.Success
    }
}


