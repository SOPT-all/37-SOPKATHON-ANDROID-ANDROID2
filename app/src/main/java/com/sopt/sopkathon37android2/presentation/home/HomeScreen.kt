package com.sopt.sopkathon37android2.presentation.home

import HomeIssueCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import com.sopt.sopkathon37android2.presentation.home.component.HomeFloatingButton
import com.sopt.sopkathon37android2.presentation.home.component.HomeVoteCard
import com.sopt.sopkathon37android2.presentation.home.component.TagType

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
fun IssueScreen(
    uiState: HomeState,
    onClick: () -> Unit = {},
    onBoomUpCardClick: () -> Unit = {},
    onIssueCardClick: (String) -> Unit = {},
    onBoomUpClick: (String) -> Unit = {},
    onToggleClick: () -> Unit = {},
    onSortClick: () -> Unit = {},
    onFloatingButtonClick: () -> Unit = {}
) {
    Scaffold(
        containerColor = SopkathonTheme.colors.gray01,
        floatingActionButton = {
            HomeFloatingButton(onClick = onFloatingButtonClick)
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1. 개선사항 안내 배너
            item {
                HomeBanner(
                    bannerImage = R.drawable.img_issue_banner, // 실제 배너 이미지 리소스
                    modifier = Modifier.padding()
                )
            }

            // 2. 인기 안건 섹션
            item {
                Column(
                    modifier = Modifier.padding(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "🔥 실시간 인기 안건",
                        style = SopkathonTheme.typography.title.sb_16,
                        color = SopkathonTheme.colors.gray05
                    )

                    HomeVoteCard(
                        tag = "전체",
                        tagType = TagType.ALL,
                        dDay = "D-1",
                        title = "F동 건물에 엘리베이터 설치 해주세요",
                        author = "컴퓨터공학과 학생회장",
                        currentCount = 25,
                        maxCount = 50,
                        progressText = "투표 가능까지 1명 남았어요",
                        onItemClick = onBoomUpCardClick
                    )
                }
            }

            // 3. 필터링 영역
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        HomeToggle(
                            isActivated = uiState.isActivated,
                            onToggleClick = onToggleClick
                        )

                        Text(
                            text = "타 단과대 제외",
                            style = SopkathonTheme.typography.body.m_14,
                            color = SopkathonTheme.colors.gray05,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    Text(
                        text = "추천순 ▼",
                        style = SopkathonTheme.typography.body.m_14,
                        color = SopkathonTheme.colors.gray04
                    )
                }
            }


            items(uiState.issueList) { issue ->
                HomeIssueCard(
                    tag = issue.tag,
                    tagType = issue.tagType,
                    dDay = issue.dDay,
                    title = issue.title,
                    author = issue.author,
                    boomUpCount = issue.boomUpCount,
                    isBoomUpFilled = issue.isBoomUpFilled,
                    onBoomUpClick = { onBoomUpClick(issue.id) },
                    onItemClick = { onIssueCardClick(issue.id) },
                )
            }
        }
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
