package com.sopt.sopkathon37android2.presentation.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.sopt.sopkathon37android2.presentation.home.HomeViewModel
import com.sopt.sopkathon37android2.presentation.register.navigation.registerGraph
import com.sopt.sopkathon37android2.presentation.home.navigation.homeGraph
import com.sopt.sopkathon37android2.presentation.vote.navigation.voteGraph

@Composable
fun MainNavHost(
    navigator: MainNavigator,
    paddingValues: PaddingValues,
    homeViewModel: HomeViewModel,
    modifier: Modifier = Modifier,
) {
    val clearStackNavOptions =
        navOptions {
            popUpTo(0) { inclusive = true }
            launchSingleTop = true
            restoreState = false
        }

    val keepStackNavOptions =
        navOptions {
            launchSingleTop = true
            restoreState = true
        }

    NavHost(
        navController = navigator.navController,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
        startDestination = navigator.startDestination,
        modifier = modifier,
    ) {
        homeGraph(
            paddingValues = paddingValues,
            homeViewModel = homeViewModel,
            onNavigateToRegister = { navigator.navigateToRegister(keepStackNavOptions) },
            onNavigateToVote = { navigator.navigateToVote(keepStackNavOptions) },
        )

        registerGraph(
            paddingValues = paddingValues,
            onNavigateUp = { navigator.navigateUp() },
        )

        voteGraph(
            paddingValues = paddingValues,
            onNavigateUp = { navigator.navigateUp() },
        )
    }
}
