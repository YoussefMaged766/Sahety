package com.devyoussef.signup.domain

import com.devyoussef.designsystem.StringExtensions.errorIfBlank
import com.devyoussef.designsystem.StringExtensions.errorIfEmailInvalid
import com.devyoussef.designsystem.StringExtensions.errorIfLengthInvalid
import com.devyoussef.designsystem.StringExtensions.errorIfPasswordInvalid
import com.devyoussef.designsystem.StringExtensions.errorIfPhoneInvalid
import javax.inject.Inject

class SignUpUseCase @Inject constructor() {
    fun validateFullName(fullName: String): ValidationResult {
        fullName.errorIfBlank("Full name")?.let { return ValidationResult.Error(it) }
        fullName.errorIfLengthInvalid("Full name", min = 3, max = 50)
            ?.let { return ValidationResult.Error(it) }
        return ValidationResult.Success
    }

    fun validateEmail(email: String): ValidationResult {
        email.errorIfBlank("Email")?.let { return ValidationResult.Error(it) }
        email.errorIfLengthInvalid("Email", max = 50)?.let { return ValidationResult.Error(it) }
        email.errorIfEmailInvalid()?.let { return ValidationResult.Error(it) }
        return ValidationResult.Success
    }

    fun validatePassword(password: String): ValidationResult {
        password.errorIfBlank("Password")?.let { return ValidationResult.Error(it) }
        password.errorIfLengthInvalid("Password", min = 8, max = 120)
            ?.let { return ValidationResult.Error(it) }
        password.errorIfPasswordInvalid()?.let { return ValidationResult.Error(it) }
        return ValidationResult.Success
    }

    fun validateRePassword(password: String, rePassword: String): ValidationResult {
        return if (password != rePassword) {
            ValidationResult.Error("Passwords do not match.")
        } else ValidationResult.Success
    }

    fun validatePhone(phone: String): ValidationResult {
        phone.errorIfBlank("Phone")?.let { return ValidationResult.Error(it) }
        phone.errorIfPhoneInvalid()?.let { return ValidationResult.Error(it) }
        return ValidationResult.Success
    }
}

sealed class ValidationResult {
    object Success : ValidationResult()
    data class Error(val message: String) : ValidationResult()
    object Default : ValidationResult()

}