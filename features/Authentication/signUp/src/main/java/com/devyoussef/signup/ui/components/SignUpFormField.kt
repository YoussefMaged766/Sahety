package com.devyoussef.signup.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.devyoussef.designsystem.SahetyTextField
import com.devyoussef.designsystem.theme.SahetyTheme
import com.devyoussef.signup.domain.validation.ValidationResult
import com.devyoussef.signup.ui.FormField

/**
 * Reusable form field component for SignUp screen
 * Reduces code duplication and improves maintainability
 * Applies DRY (Don't Repeat Yourself) principle
 */
@Composable
fun SignUpFormField(
    modifier: Modifier = Modifier,
    field: FormField<String>,
    onValueChange: (String) -> Unit,
    label: String,
    iconRes: Int,
    isPassword: Boolean = false,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    SahetyTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp),
        value = field.value,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                painter = painterResource(iconRes),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = SahetyTheme.colors.secondaryText
            )
        },
        label = label,
        isPassword = isPassword,
        isError = field.validation is ValidationResult.Error,
        errorMessage = (field.validation as? ValidationResult.Error)?.message.orEmpty(),
        imeAction = imeAction,
        keyboardType = keyboardType,
        keyboardActions = keyboardActions
    )
}

