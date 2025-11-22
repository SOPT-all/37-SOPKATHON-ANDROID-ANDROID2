package com.sopt.sopkathon37android2.presentation.d

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DRoute(
    paddingValues: PaddingValues
){
    DScreen(
        paddingValues = paddingValues
    )
}

@Composable
private fun DScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
    ) {

    }
}
