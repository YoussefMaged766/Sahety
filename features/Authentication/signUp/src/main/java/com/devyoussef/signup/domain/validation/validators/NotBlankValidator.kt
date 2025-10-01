package com.devyoussef.signup.domain.validation.validators

import com.devyoussef.signup.domain.validation.ValidationResult
import com.devyoussef.signup.domain.validation.Validator

/**
 * Validates that a string is not blank
 * Single Responsibility: Only checks if field is not blank
 */
class NotBlankValidator(
    private val fieldName: String
) : Validator<String> {
    override fun validate(value: String): ValidationResult {
        return if (value.isBlank()) {
            ValidationResult.Error("$fieldName cannot be empty")
        } else {
            ValidationResult.Success
        }
    }
}

