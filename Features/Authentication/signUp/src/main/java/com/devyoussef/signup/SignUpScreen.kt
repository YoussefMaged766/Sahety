package com.devyoussef.signup

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devyoussef.designsystem.AppFonts
import com.devyoussef.designsystem.SahetyTextField
import com.devyoussef.designsystem.theme.SahetyTheme
import com.devyoussef.signup.R

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier
) {
    val radioOptions = listOf(
        stringResource(R.string.patient),
        stringResource(R.string.doctor),
        stringResource(R.string.clinic_manager)
    )
    val (selectedOption, onOptionSelected) = rememberSaveable { mutableStateOf(radioOptions[0]) }

    Scaffold() { innerPadding ->
        Column(
            modifier = modifier
                .background(SahetyTheme.colors.bgColor)
                .padding(innerPadding)
                .fillMaxSize()

        ) {
            HeaderSection(modifier = Modifier)
            SignUpUsers(
                radioOptions = radioOptions,
                selectedOption = selectedOption,
                onOptionSelected = onOptionSelected
            )

            SahetyTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp)
                    ,
                value = "",
                onValueChange = {},
                label = stringResource(R.string.email),

            )

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
                    fontFamily = FontFamily(Font(com.devyoussef.designsystem.R.font.nunito_bold))
                )
            )

            Text(
                text = "Join us and start your journey today.",
                style = TextStyle(
                    color = SahetyTheme.colors.primaryText,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(com.devyoussef.designsystem.R.font.nunito_regular))
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
            .padding(start = 24.dp, end = 12.dp),
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
                        indication = ripple(color = SahetyTheme.colors.primaryContainer)
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

