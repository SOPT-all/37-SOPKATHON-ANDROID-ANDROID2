package com.sopt.sopkathon37android2.presentation.home.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun IssueScreen() {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(),
        ) {
            // 상단 배너
            item {
                Text("배너")
            }
            // 게시글 리스트
        }
    }



@Composable
@Preview(showBackground = true)
private fun IssueColumnScreenPreview(){
    IssueScreen()
}
