package com.devyoussef.signup.domain.validation.validators

import com.devyoussef.signup.domain.validation.ValidationResult
import com.devyoussef.signup.domain.validation.Validator

/**
 * Validates password strength
 * Single Responsibility: Only checks password complexity requirements
 */
class PasswordValidator : Validator<String> {
    override fun validate(value: String): ValidationResult {
        val hasUpperCase = value.any { it.isUpperCase() }
        val hasLowerCase = value.any { it.isLowerCase() }
        val hasDigit = value.any { it.isDigit() }
        
        return when {
            !hasUpperCase -> ValidationResult.Error("Password must contain uppercase letter")
            !hasLowerCase -> ValidationResult.Error("Password must contain lowercase letter")
            !hasDigit -> ValidationResult.Error("Password must contain a digit")
            else -> ValidationResult.Success
        }
    }
}

