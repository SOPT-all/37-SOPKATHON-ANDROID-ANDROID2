package com.sopt.sopkathon37android2.presentation.vote.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme
import kotlin.math.max
import kotlin.math.roundToInt

@Composable
fun VoteResult(
    maxVoter: Int,
    currentVoter: Int,
    isAgreed: Boolean,
    modifier: Modifier = Modifier,
) {
    val agreeColor = if (isAgreed) SopkathonTheme.colors.arg01 else SopkathonTheme.colors.gray03
    val disagreeColor =
        if (isAgreed) SopkathonTheme.colors.gray03 else SopkathonTheme.colors.disArg01

    val voterPercent = (currentVoter.toFloat() / maxVoter.toFloat() * 100).roundToInt()

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "$voterPercent%",
                color = if (isAgreed) agreeColor else disagreeColor,
                style = SopkathonTheme.typography.title.sb_16,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "$currentVoter 명 ${if (isAgreed) "찬성" else "반대"}",
                color = if (isAgreed) agreeColor else disagreeColor,
                style = SopkathonTheme.typography.body.m_14,
            )
            Text(
                text = " / 전체 $maxVoter 명 참여",
                color = SopkathonTheme.colors.gray04,
                style = SopkathonTheme.typography.body.m_14,
            )
        }
        Spacer(modifier = Modifier.height(5.5.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = agreeColor,
                        shape = RoundedCornerShape(topStart = 99.dp, bottomStart = 99.dp)
                    )
                    .height(8.dp)
                    .weight((voterPercent / 100f))
            )
            Box(
                modifier = Modifier
                    .background(
                        color = disagreeColor,
                        shape = RoundedCornerShape(topEnd = 99.dp, bottomEnd = 99.dp)
                    )
                    .height(8.dp)
                    .weight((100 - voterPercent) / 100f)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun VoteResultPreview() {
    VoteResult(
        maxVoter = 100,
        currentVoter = 50,
        isAgreed = true
    )
}