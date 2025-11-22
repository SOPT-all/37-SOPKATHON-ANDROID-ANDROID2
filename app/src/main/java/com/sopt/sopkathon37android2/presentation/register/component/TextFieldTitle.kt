package com.sopt.sopkathon37android2.presentation.register.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme

@Composable
fun TextFieldTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = SopkathonTheme.typography.body.m_14,
        color = SopkathonTheme.colors.gray05,
        modifier = modifier
            .fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
private fun TextFieldTitlePreview() {
    TextFieldTitle(
        text = "제목"
    )
}