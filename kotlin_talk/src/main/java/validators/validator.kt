package validators

import KotlinPerson
import ValidationResult

interface Validator {
    fun validate(p: KotlinPerson?): ValidationResult
}

class NameValidator : Validator {
    override fun validate(p: KotlinPerson?): ValidationResult {
        println("Validate person name")
        return if (p?.name?.length ?: 0 < 3) ValidationResult.Failure("Name too short") else ValidationResult.Success
    }
}

class SurnameValidator : Validator {
    override fun validate(p: KotlinPerson?): ValidationResult {
        println("Validate person surname")
        return if (p?.surname?.length ?: 0 < 3) ValidationResult.Failure("Surname too short") else ValidationResult.Success
    }
}

class AgeValidator : Validator {
    override fun validate(p: KotlinPerson?): ValidationResult {
        println("Validate person age")

        return if (p?.age == null) {
            ValidationResult.Failure("Invalid data")
        } else {
            when {
                validateNonNegative(p) -> return ValidationResult.Failure("Negative value in age")
                validateOldEnough(p) -> return ValidationResult.Failure("Too young")
                validateNotTooOld(p) -> return ValidationResult.Failure("Too old")
                else -> ValidationResult.Success
            }
        }
    }

    private val validateNotTooOld: (p: KotlinPerson) -> Boolean = { it.age > 110 }
    private val validateOldEnough: (p: KotlinPerson) -> Boolean = { it.age < 18 }
    private val validateNonNegative: (p: KotlinPerson) -> Boolean = { it.age <= 0 }
}
