package com.devyoussef.signup.domain.validation

sealed class ValidationResult {
    object Success : ValidationResult()
    data class Error(val message: String) : ValidationResult()
    object Default : ValidationResult()
}

