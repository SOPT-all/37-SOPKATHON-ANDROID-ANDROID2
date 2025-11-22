package com.sopt.sopkathon37android2.presentation.a.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.sopkathon37android2.core.navigation.Route
import com.sopt.sopkathon37android2.presentation.a.ARoute
import kotlinx.serialization.Serializable

fun NavController.navigateToA(navOptions: NavOptions? = null) {
    navigate(AScreen, navOptions)
}

fun NavGraphBuilder.aGraph(
    paddingValues: PaddingValues,
    onNavigateToB: () -> Unit,
) {
    composable<AScreen> {
        ARoute(
            paddingValues = paddingValues,
            onNavigateToB = onNavigateToB,
        )
    }
}

@Serializable
data object AScreen : Route
