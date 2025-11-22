package com.sopt.sopkathon37android2.presentation.splash.navigation

import android.window.SplashScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.sopkathon37android2.core.navigation.Route
import com.sopt.sopkathon37android2.presentation.splash.SplashRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToSplash(navOptions: NavOptions? = null){
    navigate(Splash, navOptions)
}

fun NavGraphBuilder.splashGraph(
    paddingValues: PaddingValues,
    onNavigateToB: () -> Unit
){
    composable<SplashScreen> {
        SplashRoute(
            paddingValues = paddingValues,
        )
    }
}

@Serializable
data object Splash: Route
