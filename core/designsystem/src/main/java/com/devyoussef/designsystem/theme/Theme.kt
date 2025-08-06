package com.devyoussef.designsystem.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.devyoussef.designsystem.CustomColors


@Composable
fun SahetyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val customColors = if (darkTheme) DarkCustomColors else LightCustomColors


    CompositionLocalProvider(
        LocalCustomColors provides customColors,
        localCustomShapes provides Shapes,
        content = content
    )


//    MaterialTheme(
//        colorScheme = colorScheme,
//        typography = Typography,
//        shapes = Shapes,
//        content = content
//    )
}

object SahetyTheme {
    val colors: CustomColors
        @Composable
        get() = LocalCustomColors.current

    val shapes: Shapes
        @Composable
        get() = localCustomShapes.current
}
