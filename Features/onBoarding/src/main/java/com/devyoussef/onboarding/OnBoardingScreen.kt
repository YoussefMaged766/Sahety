package com.devyoussef.onboarding

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    mainNavController: NavController,
    viewModel: OnboardingViewModel = hiltViewModel(),
    navigateToOnBoarding: () -> Unit,
    navigateToHome: () -> Unit
) {
    val isOnboardingCompleted by viewModel.isOnboardingCompleted().collectAsState(false)
    val context = LocalContext.current

    Text(
        modifier = modifier.fillMaxSize(),
        text = "OnBoarding Screen",
        style = MaterialTheme.typography.headlineLarge,
        textAlign = TextAlign.Center
    )
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun PreviewOnBoardingScreen() {
//    OnBoardingScreen(mainNavController = rememberNavController() , navigateToOnBoarding = {}, navigateToHome = {})
//}