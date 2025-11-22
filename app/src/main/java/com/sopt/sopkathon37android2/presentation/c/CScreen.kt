package com.sopt.sopkathon37android2.presentation.c

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CRoute(
    paddingValues: PaddingValues,
    onNavigateToD: () -> Unit,
) {
    CScreen(
        paddingValues = paddingValues,
        onNavigateToD = onNavigateToD,
    )
}

@Composable
private fun CScreen(
    paddingValues: PaddingValues,
    onNavigateToD: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .padding(paddingValues = paddingValues),
    ) {
        Text(
            text = "C",
            modifier = Modifier.clickable(onClick = onNavigateToD),
        )
    }
}
