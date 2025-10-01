package com.devyoussef.signup.domain

import com.devyoussef.signup.domain.validation.CompositeValidator
import com.devyoussef.signup.domain.validation.ValidationResult
import com.devyoussef.signup.domain.validation.validators.*
import javax.inject.Inject

/**
 * Use Case for Sign Up validation
 * Applies Strategy Pattern through validators
 * Applies Dependency Inversion Principle (depends on Validator abstraction)
 * Applies Open/Closed Principle (open for extension via new validators)
 */
class SignUpUseCase @Inject constructor() {
    
    // Composite validators combining multiple validation rules
    private val fullNameValidator = CompositeValidator(
        listOf(
            NotBlankValidator("Full name"),
            LengthValidator("Full name", min = 3, max = 50)
        )
    )
    
    private val emailValidator = CompositeValidator(
        listOf(
            NotBlankValidator("Email"),
            LengthValidator("Email", max = 50),
            EmailValidator()
        )
    )
    
    private val passwordValidator = CompositeValidator(
        listOf(
            NotBlankValidator("Password"),
            LengthValidator("Password", min = 8, max = 120),
            PasswordValidator()
        )
    )
    
    private val phoneValidator = CompositeValidator(
        listOf(
            NotBlankValidator("Phone"),
            PhoneValidator()
        )
    )
    
    /**
     * Validates full name field
     * Delegates to composite validator
     */
    fun validateFullName(fullName: String): ValidationResult = 
        fullNameValidator.validate(fullName)
    
    /**
     * Validates email field
     * Delegates to composite validator
     */
    fun validateEmail(email: String): ValidationResult = 
        emailValidator.validate(email)
    
    /**
     * Validates password field
     * Delegates to composite validator
     */
    fun validatePassword(password: String): ValidationResult = 
        passwordValidator.validate(password)
    
    /**
     * Validates re-password field matches original password
     * Uses dynamic password matching validator
     */
    fun validateRePassword(password: String, rePassword: String): ValidationResult = 
        PasswordMatchValidator { password }.validate(rePassword)
    
    /**
     * Validates phone number field
     * Delegates to composite validator
     */
    fun validatePhone(phone: String): ValidationResult = 
        phoneValidator.validate(phone)
}