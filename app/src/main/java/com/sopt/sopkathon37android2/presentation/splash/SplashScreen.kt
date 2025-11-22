package com.sopt.sopkathon37android2.presentation.splash

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SplashRoute(
    paddingValues: PaddingValues
){
    SplashScreen(
        paddingValues = paddingValues
    )
}

@Composable
private fun SplashScreen(
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
