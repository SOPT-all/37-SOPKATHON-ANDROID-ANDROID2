package com.sopt.sopkathon37android2.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme

enum class TagType { ALL, MY, OTHER }

@Composable
fun HomeTagChip(
    text: String,
) {
    val backgroundColor = when (type) {
        TagType.ALL -> SopkathonTheme.colors.tagAll
        TagType.MY -> SopkathonTheme.colors.tagMy
        TagType.OTHER -> SopkathonTheme.colors.tagOther
    }

    val textColor = SopkathonTheme.colors.gray05

    Text(
        text = text,
        style = SopkathonTheme.typography.caption.m_10,
        color = textColor,
            .clip(RoundedCornerShape(99.dp))
            .background(backgroundColor)
            .padding(horizontal = 8.dp, vertical = 3.dp)
    )
}


@Preview(showBackground = true)
@Composable
    Column()
    {
        HomeTagChip(text = "전체", type = TagType.ALL)
        HomeTagChip(text = "미술대학", type = TagType.MY)
        HomeTagChip(text = "공과대학", type = TagType.OTHER)
    }
}
