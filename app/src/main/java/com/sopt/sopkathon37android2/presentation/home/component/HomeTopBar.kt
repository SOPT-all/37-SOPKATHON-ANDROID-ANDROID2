package com.sopt.sopkathon37android2.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sopkathon37android2.R
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme
import com.sopt.sopkathon37android2.presentation.home.model.HomeTab

@Composable
fun HomeTopBar(
    isIssueSelected: Boolean,
    isVoteSelected: Boolean,
    onAgendaClick: () -> Unit,
    onVoteClick: () -> Unit,
    modifier: Modifier = Modifier
){
    val textIssueColor = if (isIssueSelected) {
        SopkathonTheme.colors.black
    } else {
        SopkathonTheme.colors.gray03
    }

    val textVoteColor = if (isVoteSelected) {
        SopkathonTheme.colors.black
    } else {
        SopkathonTheme.colors.gray03
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 11.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = HomeTab.ISSUE.tabTitle,
            color = textIssueColor,
            style = SopkathonTheme.typography.header.b_24,
            modifier = Modifier.clickable(onClick = onAgendaClick),
        )

        Spacer(modifier = Modifier.width(24.dp))

        Text(
            text = HomeTab.VOTE.tabTitle,
            color = textVoteColor,
            style = SopkathonTheme.typography.header.b_24,
            modifier = Modifier.clickable(onClick = onVoteClick),
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = "투표중",
            color = SopkathonTheme.colors.black,
            style = SopkathonTheme.typography.caption.m_12,
            modifier = Modifier
                .clip(RoundedCornerShape(99.dp))
                .background(color = SopkathonTheme.colors.keyLight)
                .padding(horizontal = 5.dp, vertical = 3.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.img_profile),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(32.dp)
        )
    }
}
