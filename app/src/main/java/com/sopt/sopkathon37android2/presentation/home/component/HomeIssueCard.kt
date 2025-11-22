import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sopkathon37android2.R
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme
import com.sopt.sopkathon37android2.presentation.home.component.HomeTagChip
import com.sopt.sopkathon37android2.presentation.home.component.TagType

@Composable
fun HomeIssueCard(
    tag: String,
    tagType: TagType,
    dDay: String,
    title: String,
    author: String,
    boomUpCount: String,
    isBoomUpFilled: Boolean = false,
    onBoomUpClick: () -> Unit = {},
    onItemClick: () -> Unit = {}
) {
    // 제목: 18자 제한
    val displayedTitle = remember(key1 = title) {
        if (title.length > 18) {
            title.take(18) + "..."
        } else {
            title
        }
    }

    // 작성자: 10자 제한
    val displayedAuthor = remember(key1 = author) {
        if (author.length > 10) {
            author.take(10) + "..."
        } else {
            author
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(104.dp)
            .clickable { onItemClick() },
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(containerColor = SopkathonTheme.colors.white)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 왼쪽: 안건 정보
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                // 태그 + D-Day
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

                // 제목 (18자 제한)
                Text(
                    text = displayedTitle,
                    style = SopkathonTheme.typography.title.sb_14,
                    color = SopkathonTheme.colors.gray05,
                    maxLines = 1
                )

                // 작성자 (10자 제한)
                Text(
                    text = displayedAuthor,
                    style = SopkathonTheme.typography.caption.m_12,
                    color = SopkathonTheme.colors.gray04,
                    maxLines = 1
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // 오른쪽: 추천 버튼 (클릭 시 filled 전환, 재클릭 불가)
            BoomUpButton(
                count = boomUpCount,
                isFilled = isBoomUpFilled,
                onClick = onBoomUpClick,
                enabled = !isBoomUpFilled // filled 상태면 클릭 불가
            )
        }
    }
}

@Composable
private fun BoomUpButton(
    count: String,
    isFilled: Boolean,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.clickable(enabled = enabled) { onClick() }
    ) {
        Image(
            painter = painterResource(
                id = if (isFilled) {
                    R.drawable.ic_home_boomup
                } else {
                    R.drawable.ic_home_boomup_empty
                }
            ),
            contentDescription = "추천",
            modifier = Modifier.size(36.dp)
        )

        Text(
            text = count,
            style = SopkathonTheme.typography.caption.sb_12,
            color = SopkathonTheme.colors.gray05
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeIssueCardPreview() {
    SopkathonTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            HomeIssueCard(
                tag = "전체",
                tagType = TagType.ALL,
                dDay = "D-3",
                title = "학관에 쓰레기통 설치해주세요",
                author = "심리학과 학생",
                boomUpCount = "1.5천",
                isBoomUpFilled = false
            )

            HomeIssueCard(
                tag = "미술대학",
                tagType = TagType.MY,
                dDay = "D-2",
                title = "집가서자고싶다집가서자고싶다집가서자고싶다",
                author = "집보내줘집보내줘집보내줘집보내줘",
                boomUpCount = "1.5천",
                isBoomUpFilled = true
            )
        }
    }
}