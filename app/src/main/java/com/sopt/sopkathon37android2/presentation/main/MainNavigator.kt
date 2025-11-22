package com.sopt.sopkathon37android2.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import com.sopt.sopkathon37android2.presentation.a.navigation.navigateToA
import com.sopt.sopkathon37android2.presentation.b.navigation.navigateToB
import com.sopt.sopkathon37android2.presentation.c.navigation.navigateToC
import com.sopt.sopkathon37android2.presentation.d.navigation.navigateToD
import com.sopt.sopkathon37android2.presentation.splash.navigation.Splash

class MainNavigator(
    val navController: NavHostController
) {
    val startDestination = Splash

    fun navigateToA(navOptions: NavOptions) {
        navController.navigateToA(navOptions)
    }

    fun navigateToB(navOptions: NavOptions) {
        navController.navigateToB(navOptions)
    }

    fun navigateToC(navOptions: NavOptions) {
        navController.navigateToC(navOptions)
    }

    fun navigateToD(navOptions: NavOptions) {
        navController.navigateToD(navOptions)
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController()
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}
