package com.devyoussef.signup.domain.validation.validators

import com.devyoussef.signup.domain.validation.ValidationResult
import com.devyoussef.signup.domain.validation.Validator

/**
 * Validates phone number format
 * Single Responsibility: Only checks phone number format validity
 */
class PhoneValidator : Validator<String> {
    private val phoneRegex = "^[+]?[0-9]{10,15}\$".toRegex()
    
    override fun validate(value: String): ValidationResult {
        return if (!value.matches(phoneRegex)) {
            ValidationResult.Error("Invalid phone number format")
        } else {
            ValidationResult.Success
        }
    }
}

