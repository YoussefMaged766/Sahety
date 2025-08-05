package com.devyoussef.splash

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController


import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier = Modifier, mainNavController: NavController , navigateToOnBoarding: () -> Unit = {}) {

    LaunchedEffect(true) {
        // Simulate a delay for the splash screen
        delay(2000)

        // Navigate to the OnBoarding screen after the delay
//        mainNavController.navigate(Screens.OnBoardingScreen) {
//            popUpTo(Screens.SplashScreen) {
//                inclusive = true
//            }
//        }
        navigateToOnBoarding()
    }

    Text(
        modifier = modifier,
        text = "Welcome to Sahety",
        style = MaterialTheme.typography.headlineLarge,
        textAlign = TextAlign.Center
    )

}