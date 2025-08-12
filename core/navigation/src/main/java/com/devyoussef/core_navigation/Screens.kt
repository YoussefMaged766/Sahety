package com.devyoussef.core_navigation

import kotlinx.serialization.Serializable

sealed class Screens {

    @Serializable
    data object SplashScreen : Screens()

    @Serializable
    data object OnBoardingScreen : Screens()

    @Serializable
    data object IntroScreen : Screens()

    @Serializable
    data object SignUpScreen : Screens()

    @Serializable
    data object HomeScreen : Screens()

}