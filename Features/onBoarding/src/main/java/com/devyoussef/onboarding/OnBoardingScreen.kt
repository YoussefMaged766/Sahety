package com.devyoussef.onboarding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    viewModel: OnboardingViewModel = hiltViewModel(),
    navigateToOnBoarding: () -> Unit,
    navigateToHome: () -> Unit
) {
    val isOnboardingCompleted by viewModel.isOnboardingCompleted().collectAsState(false)
    val context = LocalContext.current

    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        Box(modifier = modifier.fillMaxSize()) {
            Text(
                modifier = modifier.padding(innerPadding),
                text = "OnBoarding Screen",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )
        }
    }


}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun PreviewOnBoardingScreen() {
//    OnBoardingScreen(mainNavController = rememberNavController() , navigateToOnBoarding = {}, navigateToHome = {})
//}