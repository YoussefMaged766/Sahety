package com.devyoussef.signup.domain.validation

/**
 * Strategy pattern for validation
 * Allows flexible and extensible validation logic
 */
interface Validator<T> {
    fun validate(value: T): ValidationResult
}

/**
 * Composite pattern for chaining multiple validators
 * Enables combining multiple validation rules
 */
class CompositeValidator<T>(
    private val validators: List<Validator<T>>
) : Validator<T> {
    override fun validate(value: T): ValidationResult {
        validators.forEach { validator ->
            val result = validator.validate(value)
            if (result is ValidationResult.Error) return result
        }
        return ValidationResult.Success
    }
}

