package com.devyoussef.signup.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devyoussef.designsystem.AppFonts
import com.devyoussef.designsystem.SahetyTextField
import com.devyoussef.designsystem.theme.SahetyTheme
import com.devyoussef.signup.R
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import com.devyoussef.signup.domain.ValidationResult


@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val radioOptions = listOf(
        stringResource(R.string.patient),
        stringResource(R.string.doctor),
        stringResource(R.string.clinic_manager)
    )
    val (selectedOption, onOptionSelected) = rememberSaveable { mutableStateOf(radioOptions[0]) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val fullName by viewModel.fullName.collectAsState()
    val fullNameValidation by viewModel.fullNameValidation.collectAsState()

    val email by viewModel.email.collectAsState()
    val emailValidation by viewModel.emailValidation.collectAsState()

    val password by viewModel.password.collectAsState()
    val passwordValidation by viewModel.passwordValidation.collectAsState()

    val rePassword by viewModel.rePassword.collectAsState()
    val rePasswordValidation by viewModel.rePasswordValidation.collectAsState()

    val phone by viewModel.phone.collectAsState()
    val phoneValidation by viewModel.phoneValidation.collectAsState()


    Scaffold() { innerPadding ->
        Column(
            modifier = modifier
                .background(SahetyTheme.colors.bgColor)
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .imePadding()

        ) {
            HeaderSection(modifier = Modifier)
            SignUpUsers(
                radioOptions = radioOptions,
                selectedOption = selectedOption,
                onOptionSelected = onOptionSelected
            )
            Spacer(modifier = Modifier.height(8.dp))

//           Full Name Text Field
            SahetyTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                value = fullName,
                onValueChange = { viewModel.onFullNameChanged(value = it) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_full_name),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp),
                        tint = SahetyTheme.colors.secondaryText
                    )
                },
                label = stringResource(R.string.full_name),
                isPassword = false,
                isError = fullNameValidation is ValidationResult.Error,
                errorMessage = (fullNameValidation as? ValidationResult.Error)?.message.orEmpty(),
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            )

            Spacer(modifier = Modifier.height(16.dp))

//           Email Text Field
            SahetyTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                value = email,
                onValueChange = { viewModel.onEmailChanged(value = it) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_email),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp),
                        tint = SahetyTheme.colors.secondaryText
                    )
                },
                label = stringResource(R.string.email),
                isPassword = false,
                isError = emailValidation is ValidationResult.Error,
                errorMessage = (emailValidation as? ValidationResult.Error)?.message.orEmpty(),
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(16.dp))

//           Password Text Field
            SahetyTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                value = password,
                onValueChange = { viewModel.onPasswordChanged(value = it) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_password),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp),
                        tint = SahetyTheme.colors.secondaryText
                    )
                },
                label = stringResource(R.string.password),
                isPassword = true,
                isError = passwordValidation is ValidationResult.Error,
                errorMessage = (passwordValidation as? ValidationResult.Error)?.message.orEmpty(),
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Password
            )
            Spacer(modifier = Modifier.height(16.dp))

//           Re-Password Text Field
            SahetyTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                value = rePassword,
                onValueChange = { viewModel.onRePasswordChanged(value = it) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_password),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp),
                        tint = SahetyTheme.colors.secondaryText
                    )
                },
                label = stringResource(R.string.re_password),
                isPassword = true,
                isError = rePasswordValidation is ValidationResult.Error,
                errorMessage = (rePasswordValidation as? ValidationResult.Error)?.message.orEmpty(),
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Password
            )

            Spacer(modifier = Modifier.height(16.dp))

//           Phone Text Field
            SahetyTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                value = phone,
                onValueChange = { viewModel.onPhoneChanged(value = it) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_phone),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp),
                        tint = SahetyTheme.colors.secondaryText
                    )
                },
                label = stringResource(R.string.phone_number),
                isPassword = false,
                isError = phoneValidation is ValidationResult.Error,
                errorMessage = (phoneValidation as? ValidationResult.Error)?.message.orEmpty(),
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Phone,
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }),
                )

            Spacer(modifier = Modifier.height(24.dp))

            ElevatedButton(
                onClick = {},
                modifier = Modifier
                    .padding(horizontal = 18.dp, vertical = 16.dp)
                    .fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 16.dp),
                shape = SahetyTheme.shapes.medium,
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = SahetyTheme.colors.primaryContainer,
                    contentColor = SahetyTheme.colors.primaryText,
                    disabledContainerColor = SahetyTheme.colors.secondaryText
                ),
                enabled = viewModel.isFormValid(),
            ) {
                Text(
                    text = stringResource(R.string.sign_up), style = TextStyle(
                        fontFamily = AppFonts.NunitoSemiBold,
                        fontSize = 16.sp,
                        color = SahetyTheme.colors.primaryText
                    )
                )
            }


        }


    }


}

@Composable
fun HeaderSection(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = modifier
                .weight(1f)

        ) {
            Text(
                text = stringResource(R.string.welcome),
                style = TextStyle(
                    color = SahetyTheme.colors.primaryText,
                    fontSize = 24.sp,
                    fontFamily = AppFonts.NunitoBold
                )
            )

            Text(
                text = stringResource(R.string.join_us_and_start_your_journey_today),
                style = TextStyle(
                    color = SahetyTheme.colors.primaryText,
                    fontSize = 18.sp,
                    fontFamily = AppFonts.NunitoRegular
                )
            )
        }

        Image(
            painter = painterResource(com.devyoussef.designsystem.R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.CenterVertically)

        )
    }
}

@Composable
fun SignUpUsers(
    modifier: Modifier = Modifier,
    radioOptions: List<String>,
    selectedOption: String = radioOptions[0],
    onOptionSelected: (String) -> Unit = {}
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectableGroup()
            .padding(start = 18.dp, end = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        radioOptions.forEach { text ->
            Row(
                modifier = Modifier
                    .height(56.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton,
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(color = SahetyTheme.colors.secondaryPressed)
                    ),
                verticalAlignment = Alignment.CenterVertically,

                ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null,// null recommended for accessibility with screen readers,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = SahetyTheme.colors.primaryContainer,
                        unselectedColor = SahetyTheme.colors.secondaryText,
                    )
                )
                Text(
                    text = text,
                    style = TextStyle(
                        color = SahetyTheme.colors.primaryText,
                        fontSize = 16.sp,
                        fontFamily = AppFonts.NunitoRegular
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}


@Preview(
    name = "Light Mode",
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
fun MyComposableLightPreview() {
    SignUpScreen()
}

