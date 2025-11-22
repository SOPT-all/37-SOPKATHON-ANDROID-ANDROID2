package com.sopt.sopkathon37android2.presentation.b

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BRoute(
    paddingValues: PaddingValues,
    onNavigateToC: () -> Unit,
) {
    BScreen(
        paddingValues = paddingValues,
        onNavigateToC = onNavigateToC,
    )
}

@Composable
private fun BScreen(
    paddingValues: PaddingValues,
    onNavigateToC: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(
                    paddingValues = paddingValues,
                ),
    ) {
        Text(
            text = "B",
            modifier = Modifier.clickable(onClick = onNavigateToC),
        )
    }
}
