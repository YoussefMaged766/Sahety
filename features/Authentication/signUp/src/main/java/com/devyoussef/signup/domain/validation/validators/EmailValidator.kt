package com.devyoussef.signup.domain.validation.validators

import com.devyoussef.signup.domain.validation.ValidationResult
import com.devyoussef.signup.domain.validation.Validator

/**
 * Validates email format
 * Single Responsibility: Only checks email format validity
 */
class EmailValidator : Validator<String> {
    private val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\$".toRegex()
    
    override fun validate(value: String): ValidationResult {
        return if (!value.matches(emailRegex)) {
            ValidationResult.Error("Invalid email format")
        } else {
            ValidationResult.Success
        }
    }
}

