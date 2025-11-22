package com.sopt.sopkathon37android2.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme

@Composable
fun VoteTagChip(
    text: String,
    modifier: Modifier = Modifier,
    type: String,
) {
    val backgroundColor = when (type) {
        "ALL" -> SopkathonTheme.colors.tagAll
        "MY" -> SopkathonTheme.colors.tagMy
        "OTHER" -> SopkathonTheme.colors.tagOther
        else -> SopkathonTheme.colors.tagAll
    }

    val textColor = SopkathonTheme.colors.gray05

    Text(
        text = text,
        style = SopkathonTheme.typography.caption.m_10,
        color = textColor,
        modifier = modifier
            .clip(RoundedCornerShape(99.dp))
            .background(backgroundColor)
            .padding(horizontal = 8.dp, vertical = 3.dp)
    )
}
