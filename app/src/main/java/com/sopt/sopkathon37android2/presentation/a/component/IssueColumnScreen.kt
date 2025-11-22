package com.sopt.sopkathon37android2.presentation.a.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

// 그냥 이거를 뷰라고 생각하셈
@Composable
fun IssueColumnScreen() {
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
fun IssueColumnScreenPreview(){
    IssueColumnScreen()
}
