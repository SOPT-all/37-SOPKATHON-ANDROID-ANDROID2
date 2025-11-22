package com.sopt.sopkathon37android2.presentation.c.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.sopkathon37android2.core.navigation.Route
import com.sopt.sopkathon37android2.presentation.register.RegisterRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToRegister(navOptions: NavOptions? = null) {
    navigate(Register, navOptions)
}

fun NavGraphBuilder.registerGraph(
    paddingValues: PaddingValues,
    onNavigateUp: () -> Unit,
) {
    composable<Register> {
        RegisterRoute(
            paddingValues = paddingValues,
            onNavigateToHome = onNavigateUp,
        )
    }
}

@Serializable
data object Register : Route
