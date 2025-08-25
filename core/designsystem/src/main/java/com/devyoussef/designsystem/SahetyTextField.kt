package com.devyoussef.designsystem


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devyoussef.designsystem.theme.SahetyTheme

@Composable
fun SahetyTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    label: String,
    isPassword: Boolean = false,
    isError: Boolean = false,
    errorMessage: String = ""
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        Text(
            text = label,
            modifier = Modifier.padding(bottom = 8.dp),
            style = TextStyle(
                color = SahetyTheme.colors.secondaryText,
                fontFamily = AppFonts.NunitoRegular,
                fontSize = 14.sp
            )
        )

        Row(
            modifier = Modifier
                .background(color = SahetyTheme.colors.bgColor)
                .clip(SahetyTheme.shapes.medium)
                .border(
                    width = 1.5.dp,
                    color = when {
                        isError -> SahetyTheme.colors.error
                        value.isEmpty() -> SahetyTheme.colors.secondaryText
                        else -> SahetyTheme.colors.primaryContainer
                    },
                    shape = SahetyTheme.shapes.medium
                )
                .height(IntrinsicSize.Min)
                .fillMaxWidth()


        ) {

            TextField(
                modifier = Modifier
                    .background(color = SahetyTheme.colors.bgColor)
                    .fillMaxWidth(),
                value = value,
                onValueChange = onValueChange,
                placeholder = {
                    Text(
                        label, style = TextStyle(
                            color = SahetyTheme.colors.secondaryText,
                            fontFamily = AppFonts.NunitoRegular,
                            fontSize = 16.sp
                        )
                    )
                },
                visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(
                    keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text
                ),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedTextColor = SahetyTheme.colors.secondaryText,
                    unfocusedTextColor = SahetyTheme.colors.secondaryText,
                    cursorColor = SahetyTheme.colors.primaryText
                ),
                leadingIcon = leadingIcon,
                trailingIcon = {
                    if (isPassword) {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = null,
                                tint = SahetyTheme.colors.secondaryText
                            )
                        }
                    } else {
                        if (value.isEmpty()) return@TextField
                        IconButton(onClick = { onValueChange("") }) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = null,
                                tint = SahetyTheme.colors.secondaryText
                            )
                        }
                    }
                }
            )
        }
        if (isError && errorMessage.isNotEmpty()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 5.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_error),
                    contentDescription = null,
                    tint = SahetyTheme.colors.error
                )
                Text(
                    text = errorMessage,
                    modifier = Modifier.padding(top = 4.dp),
                    style = TextStyle(
                        color = SahetyTheme.colors.error,
                        fontFamily = AppFonts.NunitoRegular,
                        fontSize = 14.sp
                    )
                )
            }

        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SahetyTextFieldPreview() {
    SahetyTextField(
        value = "",
        onValueChange = {},
        label = "Email",
        isPassword = true,
        modifier = Modifier
    )
}