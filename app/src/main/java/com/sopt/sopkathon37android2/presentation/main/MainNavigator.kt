package com.sopt.sopkathon37android2.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import com.sopt.sopkathon37android2.presentation.c.navigation.navigateToRegister
import com.sopt.sopkathon37android2.presentation.home.navigation.Home
import com.sopt.sopkathon37android2.presentation.home.navigation.navigateToHome
import com.sopt.sopkathon37android2.presentation.vote.navigation.navigateToVote

class MainNavigator(
    val navController: NavHostController,
) {
    val startDestination = Home

    fun navigateToHome(navOptions: NavOptions) {
        navController.navigateToHome(navOptions)
    }

    fun navigateToRegister(navOptions: NavOptions) {
        navController.navigateToRegister(navOptions)
    }

    fun navigateToVote(navOptions: NavOptions) {
        navController.navigateToVote(navOptions)
    }

    fun navigateUp() {
        navController.navigateUp()
    }
}

@Composable
fun rememberMainNavigator(navController: NavHostController = rememberNavController()): MainNavigator =
    remember(navController) {
        MainNavigator(navController)
    }
