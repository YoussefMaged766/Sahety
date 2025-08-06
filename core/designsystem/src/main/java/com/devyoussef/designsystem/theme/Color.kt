package com.devyoussef.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.devyoussef.designsystem.CustomColors



val primaryContainerLight = Color(0xFF28C76F)
val primaryPressedLight = Color(0xFF24B364)
val primaryActiveLight = Color(0xFF209F59)
val primaryLightDisabled = Color(0xFF8ACBA6)
val secondaryPressedLight = Color(0xFFE0E0E0)
val whiteIconLight = Color(0xFFFFFFFF)
val bgColorLight = Color(0xFFFFFFFF)
val primaryTextLight = Color(0xFF1E1E1E)
val secondaryTextLight = Color(0xFF6E6E6E)
val textDisabledLight = Color(0xFF5D5D5D)
val onPrimaryTextLight = Color(0xFFFFFFFF)
val cardLight = Color(0xFFF8F7F4)
val disableButtonLight = Color(0xFFD6D6D6)
val disabledButtonPressedLight = Color(0xFFD4D4D4)
val dividerLight = Color(0xFFE0E0E0)
val errorLight = Color(0xFFF44336)
val successLight = Color(0xFF06FF75)
val warningLight = Color(0xFFFFC107)


val primaryDark = Color(0xFF28C76F)
val primaryPressedDark = Color(0xFF24B364)
val primaryActiveDark = Color(0xFF209F59)
val primaryDarkDisabled = Color(0xFF8ACBA6)
val secondaryPressedDark = Color(0xFF333333)
val whiteIconDark = Color(0xFFFFFFFF)
val bgColorDark = Color(0xFF1E1E1E)
val primaryTextDark = Color(0xFFFFFFFF)
val secondaryTextDark = Color(0xFFACACAC)
val onPrimaryTextDark = Color(0xFFFFFFFF)
val cardDark = Color(0xFF3C3C3C)
val disabledButton = Color(0xFF323232)
val textDisabledDark = Color(0xFFBCBCBC)
val disabledButtonDark = Color(0xFF696969)
val dividerDark = Color(0xFF696969)
val errorDark = Color(0xFFF44336)
val successDark = Color(0xFF06FF75)
val warningDark = Color(0xFFFFC107)


val LightCustomColors = CustomColors(
    primaryContainer = primaryContainerLight,
    primaryPressed = primaryPressedLight,
    primaryDisabled = primaryLightDisabled,
    primaryActive = primaryActiveLight,
    bgColor = bgColorLight,
    primaryText = primaryTextLight,
    secondaryText = secondaryTextLight,
    textDisabled = textDisabledLight,
    onPrimaryText = onPrimaryTextLight,
    card = cardLight,
    disableButton = disableButtonLight,
    disabledButtonPressed = disabledButtonPressedLight,
    divider = dividerLight,
    error = errorLight,
    success = successLight,
    warning = warningLight,
    secondaryPressed =  secondaryPressedLight,
    whiteIcon = whiteIconLight
)

val DarkCustomColors = CustomColors(
    primaryContainer = primaryDark,
    primaryPressed = primaryPressedDark,
    primaryActive = primaryActiveDark,
    primaryDisabled = primaryDarkDisabled,
    bgColor = bgColorDark,
    primaryText = primaryTextDark,
    secondaryText = secondaryTextDark,
    textDisabled = textDisabledDark,
    onPrimaryText = onPrimaryTextDark,
    card = cardDark,
    disableButton = disabledButton,
    disabledButtonPressed = disabledButtonDark,
    divider = dividerDark,
    error = errorDark,
    success = successDark,
    warning = warningDark,
    secondaryPressed = secondaryPressedDark,
    whiteIcon = whiteIconDark
)

val LocalCustomColors = staticCompositionLocalOf {
    CustomColors(
        primaryContainer = primaryContainerLight,
        primaryPressed = primaryPressedLight,
        primaryActive = primaryActiveLight,
        primaryDisabled = primaryLightDisabled,
        bgColor = bgColorLight,
        primaryText = primaryTextLight,
        secondaryText = secondaryTextLight,
        textDisabled = textDisabledLight,
        onPrimaryText = onPrimaryTextLight,
        card = cardLight,
        disableButton = disableButtonLight,
        disabledButtonPressed = disabledButtonPressedLight,
        divider = dividerLight,
        error = errorLight,
        success = successLight,
        warning = warningLight,
        secondaryPressed = secondaryPressedLight,
        whiteIcon = whiteIconLight
    )
}

