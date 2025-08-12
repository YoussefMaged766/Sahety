package com.devyoussef.sahety

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.devyoussef.core_navigation.Screens
import com.devyoussef.onboarding.IntroScreen
import com.devyoussef.onboarding.OnBoardingScreen
import com.devyoussef.signup.SignUpScreen
import com.devyoussef.splash.SplashScreen


@Composable
fun MainNavApp(mainNavController: NavHostController) {

    NavHost(
        navController = mainNavController,
        startDestination = Screens.SplashScreen
    ) {
        composable<Screens.SplashScreen> {
            SplashScreen(navigateToOnBoarding = {
                mainNavController.navigate(Screens.OnBoardingScreen) {
                    popUpTo(Screens.SplashScreen) {
                        inclusive = true
                    }
                }
            })
        }

        composable<Screens.OnBoardingScreen> {
            OnBoardingScreen(navigateToOnBoarding = {
                mainNavController.navigate(Screens.OnBoardingScreen)
            }, navigateToIntro = {
                mainNavController.navigate(Screens.IntroScreen) {
                    popUpTo(Screens.OnBoardingScreen) {
                        inclusive = true
                    }
                }
            })
        }


        composable<Screens.SignUpScreen> {
            SignUpScreen()
        }

        composable<Screens.IntroScreen> {
            IntroScreen(
                onNavigateToSignUp = {
                    mainNavController.navigate(Screens.SignUpScreen)
                }
            )
        }



    }

}