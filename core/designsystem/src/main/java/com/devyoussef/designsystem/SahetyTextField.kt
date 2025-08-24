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
import androidx.compose.material.icons.Icons
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
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
    label: String,
    isPassword: Boolean = false
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
                    color = SahetyTheme.colors.secondaryText,
                    shape = SahetyTheme.shapes.medium
                )
                .height(IntrinsicSize.Min)
                .fillMaxWidth()


        ) {

            TextField(
                modifier = Modifier.background(color = SahetyTheme.colors.bgColor),
                value = value,
                onValueChange = onValueChange,
                placeholder = { Text(label) },
                visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                },
                trailingIcon = {
                    if (isPassword) {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = null
                            )
                        }
                    }
                }
            )
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