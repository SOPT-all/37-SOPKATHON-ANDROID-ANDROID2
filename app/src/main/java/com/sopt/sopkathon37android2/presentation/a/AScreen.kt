package com.sopt.sopkathon37android2.presentation.a

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ARoute(
    paddingValues: PaddingValues,
    onNavigateToB: () -> Unit,
    viewModel: AViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    AScreen(
        paddingValues = paddingValues,
        onNavigateToB = onNavigateToB,
    )
}

@Composable
private fun AScreen(
    paddingValues: PaddingValues,
    onNavigateToB: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
    ) {
        Text(
            text = "A",
            modifier = Modifier.clickable(onClick = onNavigateToB),
        )
    }
}
