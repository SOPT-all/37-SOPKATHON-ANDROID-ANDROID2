package com.sopt.sopkathon37android2.presentation.home

import HomeIssueCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sopkathon37android2.R
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme
import com.sopt.sopkathon37android2.presentation.home.component.HomeBanner
import com.sopt.sopkathon37android2.presentation.home.component.HomeToggle
import com.sopt.sopkathon37android2.presentation.home.component.HomeVoteCard
import com.sopt.sopkathon37android2.presentation.home.component.TagType

@Composable
fun IssueScreen(
    uiState: IssueState,
    onClick: () -> Unit = {},
    onBoomUpCardClick: () -> Unit = {},
    onIssueCardClick: (String) -> Unit = {},
    onBoomUpClick: (String) -> Unit = {},
    onToggleClick: () -> Unit = {},
    onSortClick: () -> Unit = {},
    onFloatingButtonClick: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 1. 개선사항 안내 배너
        item {
            Spacer(modifier = Modifier.height(17.dp))
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

            Spacer(modifier = Modifier.height(28.dp))
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
