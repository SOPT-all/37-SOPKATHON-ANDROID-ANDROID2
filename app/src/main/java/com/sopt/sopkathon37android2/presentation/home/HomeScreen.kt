package com.sopt.sopkathon37android2.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.sopkathon37android2.R
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme
import com.sopt.sopkathon37android2.presentation.home.component.HomeBanner
import com.sopt.sopkathon37android2.presentation.home.component.HomeToggle
import com.sopt.sopkathon37android2.presentation.home.component.HomeTopBar
import com.sopt.sopkathon37android2.presentation.home.component.HomeVote
import com.sopt.sopkathon37android2.presentation.home.model.HomeTab
import com.sopt.sopkathon37android2.presentation.home.model.VoteUiModel
import androidx.compose.foundation.lazy.items

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
            .background(color = SopkathonTheme.colors.gray01)
            .padding(paddingValues = paddingValues)
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp),
    ) {
        HomeTopBar(
            isIssueSelected = uiState.isIssueSelected,
            isVoteSelected = uiState.isVoteSelected,
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
                    voteList = uiState.voteList,
                    onVoteClick = onVoteScreenClick
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

}

@Composable
private fun VoteScreen(
    voteList: List<VoteUiModel>,
    onVoteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(bottom = 84.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(12.dp))

            HomeBanner(
                bannerImage = R.drawable.img_vote_banner
            )

            Spacer(modifier = Modifier.height(7.dp))
        }

        items(
            items = voteList,
            key = { it.id }
        ) { vote ->
            Spacer(modifier = Modifier.height(12.dp))

            HomeVote(
                detailGroupTag = vote.detailGroupTag,
                tagType = vote.tagType,
                studentCouncil = vote.studentCouncil,
                voteTotalNumber = vote.voteTotalNumber,
                detailTitle = vote.detailTitle,
                detailGroup = vote.detailGroup,
                onVoteClick = onVoteClick
            )
        }
    }
}
