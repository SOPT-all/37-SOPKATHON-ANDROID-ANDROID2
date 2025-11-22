package com.sopt.sopkathon37android2.presentation.register.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme

@Composable
fun TextFieldSemiTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = SopkathonTheme.typography.caption.m_10,
        color = SopkathonTheme.colors.gray03,
        modifier = modifier
            .fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
private fun TextFieldSemiTitlePreview() {
    TextFieldSemiTitle(
        text = "투표 기간은 등록일로부터 3주입니다"
    )
}