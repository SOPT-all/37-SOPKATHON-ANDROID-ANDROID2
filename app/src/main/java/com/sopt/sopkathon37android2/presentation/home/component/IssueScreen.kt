package com.sopt.sopkathon37android2.presentation.home.component

import HomeIssueCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sopkathon37android2.R
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme
import com.sopt.sopkathon37android2.presentation.home.HomeState
import com.sopt.sopkathon37android2.presentation.home.IssueItem

@Composable
fun IssueScreen(
    uiState: HomeState,
    onBannerClick: () -> Unit = {},
    onBoomUpCardClick: () -> Unit = {},
    onIssueCardClick: (String) -> Unit = {},
    onBoomUpClick: (String) -> Unit = {},
    onToggleClick: () -> Unit = {},
    onSortClick: () -> Unit = {},
    onFloatingButtonClick: () -> Unit = {}
) {
    Scaffold(
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
                        maxCount = 30,
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
                        .padding(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HomeToggle(
                        isActivated = uiState.isActivated,
                        onToggleClick = onToggleClick
                    )

                    // TODO: 정렬 드롭다운 추가
                    Text(
                        text = "추천순 ▼",
                        style = SopkathonTheme.typography.body.m_14,
                        color = SopkathonTheme.colors.gray04
                    )
                }
            }

            // 4. 전체 안건 목록
            item {
                Text(
                    text = "전체 안건",
                    style = SopkathonTheme.typography.title.sb_16,
                    color = SopkathonTheme.colors.gray05,
                    modifier = Modifier.padding()
                )
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

@Preview(showBackground = true)
@Composable
private fun IssueScreenPreview() {
    val dummyState = HomeState(
        isActivated = false,
        issueList = listOf(
            IssueItem(
                id = "1",
                tag = "전체",
                tagType = TagType.ALL,
                dDay = "D-3",
                title = "학관에 쓰레기통 설치해주세요",
                author = "심리학과 학생",
                boomUpCount = "1.5천",
                isBoomUpFilled = false
            ),
            IssueItem(
                id = "2",
                tag = "미술대학",
                tagType = TagType.MY,
                dDay = "D-5",
                title = "시다과 졸전 일정 변경 건의합니다",
                author = "시각디자인과",
                boomUpCount = "850",
                isBoomUpFilled = true
            ),
            IssueItem(
                id = "3",
                tag = "공과대학",
                tagType = TagType.OTHER,
                dDay = "D-7",
                title = "실습실 에어컨 추가 설치 요청",
                author = "전자공학과",
                boomUpCount = "2.1천",
                isBoomUpFilled = false
            )
        )
    )

    SopkathonTheme {
        IssueScreen(
            uiState = dummyState
        )
    }
}