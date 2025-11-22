package com.sopt.sopkathon37android2.presentation.a.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.material.progressindicator.LinearProgressIndicator


@Composable
fun AProgressBar(
    currentCount: Int, // 현재 인원 카운트
    maxCount: Int,
) {
    val progress = (currentCount.toFloat() / maxCount.toFloat()).coerceIn(0f, 1f)
    LinearProgressIndicator(
        progress = { progress }, // 람다 형태로 전달
        modifier = Modifier.fillMaxWidth(),
        color = ProgressIndicatorDefaults.linearColor,
        trackColor = ProgressIndicatorDefaults.linearTrackColor,
        strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
    )
}

@Preview(showBackground = true)
@Composable
fun AProgressBarPreview(){
    AProgressBar(5,30)
}

