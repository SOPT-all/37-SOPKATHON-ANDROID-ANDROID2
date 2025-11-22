package com.sopt.sopkathon37android2.presentation.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun RegisterRoute(
    paddingValues: PaddingValues,
    onNavigateToHome: () -> Unit,
    viewModel: RegisterViewModel = hiltViewModel(),
) {

    RegisterScreen(
        paddingValues = paddingValues,
        onNavigateToHome = onNavigateToHome,
    )
}

@Composable
private fun RegisterScreen(
    paddingValues: PaddingValues,
    onNavigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .padding(paddingValues = paddingValues),
    ) {
        Text(
            text = "C",
            modifier = Modifier.clickable(onClick = onNavigateToHome),
        )
    }
}
