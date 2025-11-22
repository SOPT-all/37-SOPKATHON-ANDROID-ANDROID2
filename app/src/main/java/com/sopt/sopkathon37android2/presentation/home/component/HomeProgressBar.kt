package com.sopt.sopkathon37android2.presentation.home.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme


@Composable
fun HomeProgressBar(
    currentCount: Int,
    maxCount: Int,
) {
    val progress = (currentCount.toFloat() / maxCount.toFloat()).coerceIn(0f, 1f)
    LinearProgressIndicator(
        progress = { progress },
        modifier = Modifier
            .fillMaxWidth()
            .height(6.dp)
            .clip(RoundedCornerShape(3.dp)),
        color = SopkathonTheme.colors.keyLight,
        trackColor = SopkathonTheme.colors.gray02,
    )
}

@Preview(showBackground = true)
@Composable
fun HomeProgressBarPreview() {
    SopkathonTheme {
        HomeProgressBar(25, 30)
    }
}

