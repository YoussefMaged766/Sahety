package com.devyoussef.signup.domain.validation.validators

import com.devyoussef.signup.domain.validation.ValidationResult
import com.devyoussef.signup.domain.validation.Validator

/**
 * Validates string length constraints
 * Single Responsibility: Only checks length requirements
 */
class LengthValidator(
    private val fieldName: String,
    private val min: Int? = null,
    private val max: Int? = null
) : Validator<String> {
    override fun validate(value: String): ValidationResult {
        return when {
            min != null && value.length < min -> 
                ValidationResult.Error("$fieldName must be at least $min characters")
            max != null && value.length > max -> 
                ValidationResult.Error("$fieldName must not exceed $max characters")
            else -> ValidationResult.Success
        }
    }
}

