package com.sopt.sopkathon37android2.presentation.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sopkathon37android2.R
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme

@Composable
fun HomeVoteCard(
    tag: String,
    tagType: TagType,
    dDay: String,
    title: String,
    author: String,
    currentCount: Int,
    maxCount: Int,
    progressText: String,
    onItemClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .clickable { onItemClick() },
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(containerColor = SopkathonTheme.colors.white)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        HomeTagChip(text = tag, type = tagType)
                        Text(
                            text = dDay,
                            style = SopkathonTheme.typography.caption.m_12,
                            color = SopkathonTheme.colors.keyDark
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = title,
                        style = SopkathonTheme.typography.title.sb_16,
                        color = SopkathonTheme.colors.gray05,
                        maxLines = 2
                    )
                }

                Icon(
                    painter = painterResource(id = R.drawable.ic_homevotecard_static),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = author,
                style = SopkathonTheme.typography.caption.m_12,
                color = SopkathonTheme.colors.gray04
            )

            Spacer(modifier = Modifier.weight(1f))

            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                HomeProgressBar(
                    currentCount = currentCount,
                    maxCount = maxCount
                )

                Text(
                    text = progressText,
                    style = SopkathonTheme.typography.caption.m_12,
                    color = SopkathonTheme.colors.gray04
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeVoteCardPreview() {
    SopkathonTheme {
        HomeVoteCard(
            tag = "전체",
            tagType = TagType.ALL,
            dDay = "D-1",
            title = "F동 건물에 엘리베이터 설치 해주세요",
            author = "컴퓨터공학과 학생회장",
            currentCount = 25,
            maxCount = 30,
            progressText = "투표 가능까지 1명 남았어요"
        )
    }
}
