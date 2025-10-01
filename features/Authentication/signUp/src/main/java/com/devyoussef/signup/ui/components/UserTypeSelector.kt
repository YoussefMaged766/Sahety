package com.devyoussef.signup.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devyoussef.designsystem.AppFonts
import com.devyoussef.designsystem.theme.SahetyTheme
import com.devyoussef.signup.R
import com.devyoussef.signup.ui.UserType

/**
 * User type selector component
 * Extracted for better separation of concerns
 * Maps between UserType enum and UI strings
 */
@Composable
fun UserTypeSelector(
    modifier: Modifier = Modifier,
    selectedUserType: UserType,
    onUserTypeSelected: (UserType) -> Unit
) {
    val userTypeOptions = listOf(
        UserType.PATIENT to stringResource(R.string.patient),
        UserType.DOCTOR to stringResource(R.string.doctor),
        UserType.CLINIC_MANAGER to stringResource(R.string.clinic_manager)
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .selectableGroup()
            .padding(start = 18.dp, end = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        userTypeOptions.forEach { (type, label) ->
            UserTypeRadioButton(
                label = label,
                selected = selectedUserType == type,
                onClick = { onUserTypeSelected(type) }
            )
        }
    }
}

/**
 * Individual radio button for user type
 * Extracted for better readability
 */
@Composable
private fun UserTypeRadioButton(
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .selectable(
                selected = selected,
                onClick = onClick,
                role = Role.RadioButton,
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(color = SahetyTheme.colors.secondaryPressed)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = null, // null recommended for accessibility with screen readers
            colors = RadioButtonDefaults.colors(
                selectedColor = SahetyTheme.colors.primaryContainer,
                unselectedColor = SahetyTheme.colors.secondaryText
            )
        )
        Text(
            text = label,
            style = TextStyle(
                color = SahetyTheme.colors.primaryText,
                fontSize = 16.sp,
                fontFamily = AppFonts.NunitoRegular
            ),
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

