package com.sopt.sopkathon37android2.presentation.register.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme
import com.sopt.sopkathon37android2.core.util.noRippleClickable

@Composable
fun RegisterButton(
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(99.dp))
            .background(if (enabled) SopkathonTheme.colors.gray04 else SopkathonTheme.colors.gray02)
            .noRippleClickable(onClick = onClick)
            .padding(vertical = 17.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = SopkathonTheme.typography.title.sb_14,
            color = if (enabled) SopkathonTheme.colors.white else SopkathonTheme.colors.gray03
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterButtonPreview() {
    RegisterButton(
        text = "안건 등록하기",
        enabled = true,
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun RegisterButtonPreview2() {
    RegisterButton(
        text = "안건 등록하기",
        enabled = false,
        onClick = {}
    )
}