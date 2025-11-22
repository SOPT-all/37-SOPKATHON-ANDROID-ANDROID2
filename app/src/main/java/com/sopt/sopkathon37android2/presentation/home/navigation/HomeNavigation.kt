package com.sopt.sopkathon37android2.presentation.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.sopkathon37android2.core.navigation.Route
import com.sopt.sopkathon37android2.presentation.home.HomeRoute
import com.sopt.sopkathon37android2.presentation.home.HomeViewModel
import kotlinx.serialization.Serializable

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    navigate(Home, navOptions)
}

fun NavGraphBuilder.homeGraph(
    paddingValues: PaddingValues,
    homeViewModel: HomeViewModel,
    onNavigateToRegister: () -> Unit,
    onNavigateToVote: () -> Unit,
) {
    composable<Home> {
        HomeRoute(
            paddingValues = paddingValues,
            onNavigateToRegister = onNavigateToRegister,
            onNavigateToVote = onNavigateToVote,
            viewModel = homeViewModel
        )
    }
}

@Serializable
data object Home : Route
