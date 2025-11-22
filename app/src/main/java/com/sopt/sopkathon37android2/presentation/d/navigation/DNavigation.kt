package com.sopt.sopkathon37android2.presentation.d.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.sopkathon37android2.core.navigation.Route
import com.sopt.sopkathon37android2.presentation.d.DRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToD(navOptions: NavOptions? = null){
    navigate(DScreen, navOptions)
}

fun NavGraphBuilder.dGraph(
    paddingValues: PaddingValues,
){
    composable<DScreen> {
        DRoute(
            paddingValues = paddingValues
        )
    }
}

@Serializable
data object DScreen : Route
