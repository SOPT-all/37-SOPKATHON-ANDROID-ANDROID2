package com.sopt.sopkathon37android2.presentation.home.component

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeFloatingButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
    ) {
        Text("등록")
    }
}




@Preview(showBackground = true)
@Composable
fun AFloatingBtnPreview()
{
    HomeFloatingButton{}
}
