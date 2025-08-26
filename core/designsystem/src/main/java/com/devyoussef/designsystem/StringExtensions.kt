package com.devyoussef.designsystem

object StringExtensions {
    fun String.errorIfBlank(fieldName: String = "This field"): String? {
        return if (isBlank()) "$fieldName is required." else null
    }

    fun String.errorIfLengthInvalid(
        fieldName: String,
        min: Int = 0,
        max: Int = Int.MAX_VALUE
    ): String? {
        return when {
            length < min -> "$fieldName must be at least $min characters."
            length > max -> "$fieldName must be at most $max characters."
            else -> null
        }
    }

    fun String.errorIfEmailInvalid(): String? {
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
        return if (!matches(emailRegex)) "Invalid email format." else null
    }

    fun String.errorIfPasswordInvalid(): String? {
        val hasUpper = any { it.isUpperCase() }
        val hasLower = any { it.isLowerCase() }
        val hasSpecial = any { !it.isLetterOrDigit() }
        val hasArabic = any { Character.UnicodeBlock.of(it) == Character.UnicodeBlock.ARABIC }
        val hasSpace = any { it.isWhitespace() }
        val hasDiacritic = any { it in listOf('َ', 'ً', 'ُ', 'ٌ', 'ِ', 'ٍ', 'ْ', 'ّ') }

        return when {
            !hasLower -> "Password must contain a lowercase letter."
            !hasUpper -> "Password must contain an uppercase letter."
            !hasSpecial -> "Password must contain a special character."
            hasArabic -> "Password must not contain Arabic letters."
            hasSpace -> "Password must not contain spaces."
            hasDiacritic -> "Password must not contain diacritics."
            else -> null
        }
    }

    fun String.errorIfPhoneInvalid(): String? {
        return if (length != 11 || !all { it.isDigit() }) "Phone must be 11 digits." else null
    }
}