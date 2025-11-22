package com.sopt.sopkathon37android2.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme
import com.sopt.sopkathon37android2.presentation.home.component.HomeToggle
import com.sopt.sopkathon37android2.presentation.home.component.HomeTopBar
import com.sopt.sopkathon37android2.presentation.home.model.HomeTab

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    onNavigateToRegister: () -> Unit,
    onNavigateToVote: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        uiState = uiState,
        paddingValues = paddingValues,
        onAgendaClick = viewModel::onAgendaClicked,
        onVoteClick = viewModel::onVoteClicked,
        onClick = onNavigateToRegister,
        onVoteScreenClick = onNavigateToVote,
        onToggleClick = viewModel::onToggleClicked
    )
}

@Composable
private fun HomeScreen(
    uiState: HomeState,
    paddingValues: PaddingValues,
    onAgendaClick: () -> Unit,
    onVoteClick: () -> Unit,
    onClick: () -> Unit,
    onVoteScreenClick: () -> Unit,
    onToggleClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues),
    ) {
        HomeTopBar(
            isSelected = uiState.isSelected,
            onAgendaClick = onAgendaClick,
            onVoteClick = onVoteClick
        )

        when (uiState.selectedTab) {
            HomeTab.ISSUE -> {
                IssueScreen(
                    uiState = uiState,
                    onClick = onClick,
                    onToggleClick = onToggleClick
                )
            }

            HomeTab.VOTE -> {
                VoteScreen(
                    onClick = onVoteScreenClick
                )
            }
        }
    }
}

@Composable
private fun IssueScreen(
    uiState: HomeState,
    onClick: () -> Unit,
    onToggleClick: () -> Unit
) {
    Column {
        Text(
            text = "zzz",
            modifier = Modifier.clickable(onClick = onClick)
        )

        HomeToggle(
            isActivated = uiState.isActivated,
            onToggleClick = onToggleClick
        )
    }

    Surface {  }
}

@Composable
private fun VoteScreen(
    onClick: () -> Unit
) {
    Column {
        Text(
            text = "ㅇㅇㅇㅇㅇ",
            modifier = Modifier.clickable(onClick = onClick)
        )
    }
}
