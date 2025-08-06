package com.devyoussef.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devyoussef.designsystem.R
import com.devyoussef.designsystem.theme.SahetyTheme


import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier = Modifier, navigateToOnBoarding: () -> Unit = {}) {

//    LaunchedEffect(true) {
//        delay(2000)
//
//        // Navigate to the OnBoarding screen after the delay
////        mainNavController.navigate(Screens.OnBoardingScreen) {
////            popUpTo(Screens.SplashScreen) {
////                inclusive = true
////            }
////        }
//        navigateToOnBoarding()
//    }

    Surface(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .background(
                    SahetyTheme.colors.bgColor
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_logo), contentDescription = null,
                modifier = modifier.size(100.dp)
            )

            Text(
                text = "Sahety",
                modifier = modifier,
                color = SahetyTheme.colors.primaryContainer,
                fontFamily = FontFamily(Font(R.font.nunito_bold))

            )

        }
    }


}