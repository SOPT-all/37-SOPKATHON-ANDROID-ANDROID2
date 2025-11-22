package com.sopt.sopkathon37android2.presentation.c.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.sopkathon37android2.core.navigation.Route
import com.sopt.sopkathon37android2.presentation.c.CRoute
import com.sopt.sopkathon37android2.presentation.vote.navigation.DScreen
import kotlinx.serialization.Serializable

fun NavController.navigateToC(navOptions: NavOptions? = null) {
    navigate(CScreen, navOptions)
}

fun NavGraphBuilder.cGraph(
    paddingValues: PaddingValues,
    onNavigateToD: () -> Unit,
) {
    composable<DScreen> {
        CRoute(
            paddingValues = paddingValues,
            onNavigateToD = onNavigateToD,
        )
    }
}

@Serializable
data object CScreen : Route
