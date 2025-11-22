package com.sopt.sopkathon37android2.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.sopkathon37android2.R
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme

@Composable
fun HomeVote(
    range: String,
    isCouncil: Boolean,
    votedCount: Int,
    title: String,
    department: String,
    onVoteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val displayedTitleText = remember(title) {
        if (title.length > 18){
            title.take(18) + "…"
        } else {
            title
        }
    }

    val displayedDetailGroupText = remember(department) {
        if (department.length > 20) {
            department.take(20) + "…"
        } else {
            department
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = SopkathonTheme.colors.white)
            .clickable(onClick = onVoteClick)
            .padding(horizontal = 20.dp)
            .padding(top = 17.dp, bottom = 21.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            VoteTagChip(
                text = department,
                type = range
            )

            if (isCouncil) {
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_pin),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }

        }

        Spacer(modifier = Modifier.height(9.dp))

        Text(
            text = displayedTitleText,
            color = SopkathonTheme.colors.black,
            style = SopkathonTheme.typography.title.sb_16
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = displayedDetailGroupText,
            color = SopkathonTheme.colors.gray04,
            style = SopkathonTheme.typography.caption.m_12
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_vote),
                contentDescription = null,
                modifier = modifier.size(24.dp)
            )

            Text(
                text = "${votedCount}명이 투표했어요",
                color = SopkathonTheme.colors.black,
                style = SopkathonTheme.typography.caption.m_12
            )
        }
    }
}
