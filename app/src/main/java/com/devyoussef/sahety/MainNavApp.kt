package com.devyoussef.sahety

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.PopUpToBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.devyoussef.authentication.HomeScreen
import com.devyoussef.core_navigation.Screens
import com.devyoussef.onboarding.OnBoardingScreen
import com.devyoussef.splash.SplashScreen


@Composable
fun MainNavApp(mainNavController: NavHostController) {

    NavHost(
        navController = mainNavController,
        startDestination = Screens.SplashScreen
    ) {
        composable<Screens.SplashScreen> {
            SplashScreen(mainNavController = mainNavController, navigateToOnBoarding = {
                mainNavController.navigate(Screens.OnBoardingScreen) {
                    popUpTo(Screens.SplashScreen) {
                        inclusive = true
                    }
                }
            })
        }

        composable<Screens.OnBoardingScreen> {
            OnBoardingScreen(mainNavController = mainNavController, navigateToOnBoarding = {
                mainNavController.navigate(Screens.OnBoardingScreen)
            }, navigateToHome = {
                mainNavController.navigate(Screens.HomeScreen) {
                    popUpTo(Screens.OnBoardingScreen) {
                        inclusive = true
                    }
                }
            })
        }


        composable<Screens.HomeScreen> {
            HomeScreen()
        }
    }

}