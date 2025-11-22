package com.sopt.sopkathon37android2.presentation.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun MainScreen(navigator: MainNavigator = rememberMainNavigator()) {
    Scaffold { innerPadding ->
        MainNavHost(
            navigator = navigator,
            paddingValues = innerPadding,
        )
    }
}
