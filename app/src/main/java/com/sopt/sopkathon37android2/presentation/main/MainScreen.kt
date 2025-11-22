package com.sopt.sopkathon37android2.presentation.main

import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import com.sopt.sopkathon37android2.presentation.home.HomeViewModel
import com.sopt.sopkathon37android2.presentation.home.component.HomeFloatingButton
import com.sopt.sopkathon37android2.presentation.home.model.HomeTab
import com.sopt.sopkathon37android2.presentation.home.navigation.Home
import com.sopt.sopkathon37android2.presentation.register.navigation.navigateToRegister

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator()
) {
    val navController = navigator.navController
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val homeViewModel: HomeViewModel = hiltViewModel()
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        floatingActionButton = {
            if (
                currentRoute == Home::class.qualifiedName &&
                uiState.selectedTab == HomeTab.ISSUE
            ) {
                HomeFloatingButton(onClick = {
                    navigator.navController.navigateToRegister()
                })
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { innerPadding ->
        MainNavHost(
            navigator = navigator,
            paddingValues = innerPadding,
            homeViewModel = homeViewModel,
        )
    }
}
