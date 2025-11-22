package com.sopt.sopkathon37android2.presentation.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.sopt.sopkathon37android2.presentation.a.navigation.aGraph
import com.sopt.sopkathon37android2.presentation.b.navigation.bGraph
import com.sopt.sopkathon37android2.presentation.register.navigation.cGraph
import com.sopt.sopkathon37android2.presentation.d.navigation.dGraph

@Composable
fun MainNavHost(
    navigator: MainNavigator,
    paddingValues: PaddingValues,
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
        aGraph(
            paddingValues = paddingValues,
            onNavigateToB = { navigator.navigateToB(keepStackNavOptions) },
        )

        bGraph(
            paddingValues = paddingValues,
            onNavigateToC = { navigator.navigateToC(keepStackNavOptions) },
        )

        cGraph(
            paddingValues = paddingValues,
            onNavigateToD = { navigator.navigateToD(keepStackNavOptions) },
        )

        dGraph(
            paddingValues = paddingValues,
        )
    }
}
