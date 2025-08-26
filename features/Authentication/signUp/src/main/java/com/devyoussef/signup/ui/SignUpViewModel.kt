package com.devyoussef.signup.ui

import androidx.lifecycle.ViewModel
import com.devyoussef.signup.domain.SignUpUseCase
import com.devyoussef.signup.domain.ValidationResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {

    // Input fields
    private val _fullName = MutableStateFlow("")
    val fullName: StateFlow<String> = _fullName

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _rePassword = MutableStateFlow("")
    val rePassword: StateFlow<String> = _rePassword

    private val _phone = MutableStateFlow("")
    val phone: StateFlow<String> = _phone

    // Validation errors
    private val _fullNameValidation = MutableStateFlow<ValidationResult>(ValidationResult.Default)
    val fullNameValidation: StateFlow<ValidationResult> = _fullNameValidation

    private val _emailValidation = MutableStateFlow<ValidationResult>(ValidationResult.Default)
    val emailValidation: StateFlow<ValidationResult> = _emailValidation

    private val _passwordValidation = MutableStateFlow<ValidationResult>(ValidationResult.Default)
    val passwordValidation: StateFlow<ValidationResult> = _passwordValidation

    private val _rePasswordValidation =
        MutableStateFlow<ValidationResult>(ValidationResult.Default)
    val rePasswordValidation: StateFlow<ValidationResult> = _rePasswordValidation

    private val _phoneValidation = MutableStateFlow<ValidationResult>(ValidationResult.Default)
    val phoneValidation: StateFlow<ValidationResult> = _phoneValidation

    // Field change handlers
    fun onFullNameChanged(value: String) {
        _fullName.value = value
        _fullNameValidation.value = signUpUseCase.validateFullName(value)
    }

    fun onEmailChanged(value: String) {
        _email.value = value
        _emailValidation.value = signUpUseCase.validateEmail(value)
    }

    fun onPasswordChanged(value: String) {
        _password.value = value
        _passwordValidation.value = signUpUseCase.validatePassword(value)
        // Also update rePassword error (in case password changed)
        _rePasswordValidation.value =
            signUpUseCase.validateRePassword(value, _rePassword.value)
    }

    fun onRePasswordChanged(value: String) {
        _rePassword.value = value
        _rePasswordValidation.value = signUpUseCase.validateRePassword(_password.value, value)
    }

    fun onPhoneChanged(value: String) {
        _phone.value = value
        _phoneValidation.value = signUpUseCase.validatePhone(value)
    }

    // Final validation before submission (if needed)
    fun isFormValid(): Boolean {
        return listOf(
            _fullNameValidation.value,
            _emailValidation.value,
            _passwordValidation.value,
            _rePasswordValidation.value,
            _phoneValidation.value
        ).all { it is ValidationResult.Success }
    }

}