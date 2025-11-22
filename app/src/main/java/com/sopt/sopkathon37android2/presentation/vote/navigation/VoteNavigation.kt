package com.sopt.sopkathon37android2.presentation.vote.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.sopkathon37android2.core.navigation.Route
import com.sopt.sopkathon37android2.presentation.vote.VoteRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToVote(navOptions: NavOptions? = null) {
    navigate(Vote, navOptions)
}

fun NavGraphBuilder.voteGraph(
    paddingValues: PaddingValues,
    onNavigateUp: () -> Unit
) {
    composable<Vote> {
        VoteRoute(
            paddingValues = paddingValues,
            onNavigateToHome = onNavigateUp
        )
    }
}

@Serializable
data object Vote : Route
