package com.sopt.sopkathon37android2.presentation.b.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.sopkathon37android2.core.navigation.Route
import com.sopt.sopkathon37android2.presentation.b.BRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToB(navOptions: NavOptions? = null) {
    navigate(BScreen, navOptions)
}

fun NavGraphBuilder.bGraph(
    paddingValues: PaddingValues,
    onNavigateToC: () -> Unit,
) {
    composable<BScreen> {
        BRoute(
            paddingValues = paddingValues,
            onNavigateToC = onNavigateToC,
        )
    }
}

@Serializable
data object BScreen : Route
