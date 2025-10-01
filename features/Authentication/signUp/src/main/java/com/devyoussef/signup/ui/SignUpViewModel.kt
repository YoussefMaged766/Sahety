package com.devyoussef.signup.ui

import androidx.lifecycle.ViewModel
import com.devyoussef.signup.domain.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * ViewModel for SignUp screen
 * Applies Single Responsibility Principle - only manages UI state
 * Reduced boilerplate by using a single state object
 */
@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {

    // Single source of truth for UI state
    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    /**
     * Handles full name field changes
     * Updates state immutably using copy()
     */
    fun onFullNameChanged(value: String) {
        _uiState.update { state ->
            state.copy(
                fullName = FormField(
                    value = value,
                    validation = signUpUseCase.validateFullName(value)
                )
            )
        }
    }

    /**
     * Handles email field changes
     * Updates state immutably using copy()
     */
    fun onEmailChanged(value: String) {
        _uiState.update { state ->
            state.copy(
                email = FormField(
                    value = value,
                    validation = signUpUseCase.validateEmail(value)
                )
            )
        }
    }

    /**
     * Handles password field changes
     * Also re-validates re-password field for consistency
     */
    fun onPasswordChanged(value: String) {
        _uiState.update { state ->
            state.copy(
                password = FormField(
                    value = value,
                    validation = signUpUseCase.validatePassword(value)
                ),
                // Re-validate rePassword when password changes
                rePassword = state.rePassword.copy(
                    validation = signUpUseCase.validateRePassword(value, state.rePassword.value)
                )
            )
        }
    }

    /**
     * Handles re-password field changes
     * Validates against current password
     */
    fun onRePasswordChanged(value: String) {
        _uiState.update { state ->
            state.copy(
                rePassword = FormField(
                    value = value,
                    validation = signUpUseCase.validateRePassword(state.password.value, value)
                )
            )
        }
    }

    /**
     * Handles phone field changes
     * Updates state immutably using copy()
     */
    fun onPhoneChanged(value: String) {
        _uiState.update { state ->
            state.copy(
                phone = FormField(
                    value = value,
                    validation = signUpUseCase.validatePhone(value)
                )
            )
        }
    }

    /**
     * Handles user type selection changes
     * Updates state immutably using copy()
     */
    fun onUserTypeChanged(userType: UserType) {
        _uiState.update { state ->
            state.copy(userType = userType)
        }
    }

    /**
     * Checks if entire form is valid
     * Delegates to state object
     */
    fun isFormValid(): Boolean = _uiState.value.isValid()
}