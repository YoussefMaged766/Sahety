package com.devyoussef.signup.domain.validation.validators

import com.devyoussef.signup.domain.validation.ValidationResult
import com.devyoussef.signup.domain.validation.Validator

/**
 * Validates that passwords match
 * Single Responsibility: Only checks password matching
 */
class PasswordMatchValidator(
    private val passwordProvider: () -> String
) : Validator<String> {
    override fun validate(value: String): ValidationResult {
        return if (value != passwordProvider()) {
            ValidationResult.Error("Passwords do not match")
        } else {
            ValidationResult.Success
        }
    }
}

