package com.sopt.sopkathon37android2.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme
import com.sopt.sopkathon37android2.presentation.home.component.HomeTopBar
import com.sopt.sopkathon37android2.presentation.home.model.HomeTab

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    onNavigateToRegister: () -> Unit,
    onNavigateToVote: () -> Unit,
    viewModel: HomeViewModel,
    voteViewModel: VoteViewModel =hiltViewModel(),
    issueViewModel: IssueViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val voteUiState by voteViewModel.uiState.collectAsStateWithLifecycle()
    val issueUiState by issueViewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        uiState = uiState,
        uiVoteState = voteUiState,
        uiIssueState = issueUiState,
        paddingValues = paddingValues,
        onAgendaClick = viewModel::onAgendaClicked,
        onVoteClick = viewModel::onVoteClicked,
        onClick = onNavigateToRegister,
        onVoteScreenClick = onNavigateToVote,
        onToggleClick = issueViewModel::onToggleClicked,
        onBoomUpClick = { issueId ->
            issueViewModel.postRecommend(issueId)
        },
        onIssueCardClick = { issueId ->
            // 여기에 상세 페이지 이동 로직 작성하면 됨
            println("카드 클릭됨! issueId = $issueId")
        }
    )
}

@Composable
private fun HomeScreen(
    uiState: HomeState,
    uiVoteState: VoteState,
    uiIssueState: IssueState,
    paddingValues: PaddingValues,
    onAgendaClick: () -> Unit,
    onVoteClick: () -> Unit,
    onClick: () -> Unit,
    onVoteScreenClick: () -> Unit,
    onToggleClick: () -> Unit,
    onBoomUpClick: (Long) -> Unit,
    onIssueCardClick: (String) -> Unit,
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
                    uiState = uiIssueState,
                    onBoomUpClick = onBoomUpClick,
                    onIssueCardClick = onIssueCardClick,
                    onToggleClick = onToggleClick,
                )
            }

            HomeTab.VOTE -> {
                VoteScreen(
                    voteList = uiVoteState.voteList,
                    onVoteClick = onVoteScreenClick
                )
            }
        }
    }
}
