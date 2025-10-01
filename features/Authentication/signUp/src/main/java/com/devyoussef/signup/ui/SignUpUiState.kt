package com.devyoussef.signup.ui

import com.devyoussef.signup.domain.validation.ValidationResult

/**
 * Centralized UI state for SignUp screen
 * Single source of truth for all form data
 */
data class SignUpUiState(
    val fullName: FormField<String> = FormField(""),
    val email: FormField<String> = FormField(""),
    val password: FormField<String> = FormField(""),
    val rePassword: FormField<String> = FormField(""),
    val phone: FormField<String> = FormField(""),
    val userType: UserType = UserType.PATIENT
) {
    /**
     * Validates if all form fields are valid
     * Single responsibility: Only checks overall form validity
     */
    fun isValid(): Boolean = listOf(
        fullName.validation,
        email.validation,
        password.validation,
        rePassword.validation,
        phone.validation
    ).all { it is ValidationResult.Success }
}

