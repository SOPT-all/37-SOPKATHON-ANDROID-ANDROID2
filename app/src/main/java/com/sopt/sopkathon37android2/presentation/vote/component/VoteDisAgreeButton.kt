package com.sopt.sopkathon37android2.presentation.vote.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun VoteDisagreeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    isEnabled: Boolean = true,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(
                color = if(isEnabled){ SopkathonTheme.colors.disArg01 } else { SopkathonTheme.colors.gray03 },
                shape = RoundedCornerShape(99.dp)
            )
            .padding(start = 21.dp, end = 20.dp, top = 11.dp, bottom = 11.dp)
            .clickable(
                onClick = onClick,
                enabled = isEnabled
            )
    ) {
        Column {
            Text(
                text = "Down",
                color = SopkathonTheme.colors.white,
                style = SopkathonTheme.typography.title.sb_16
            )
            Text(
                text = "반대",
                color = SopkathonTheme.colors.white,
                style = SopkathonTheme.typography.caption.m_12
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            painter = painterResource(R.drawable.ic_disagr),
            contentDescription = null,
            tint = SopkathonTheme.colors.white,
            modifier = Modifier
                .size(34.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun VoteButtonPreview(){
    VoteDisagreeButton(
        onClick = {}
    )
}