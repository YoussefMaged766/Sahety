package com.devyoussef.signup.ui

import com.devyoussef.signup.domain.validation.ValidationResult

/**
 * Represents a form field with its value and validation state
 * Encapsulates field data and validation together
 */
data class FormField<T>(
    val value: T,
    val validation: ValidationResult = ValidationResult.Default
)

