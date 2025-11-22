package com.sopt.sopkathon37android2.presentation.vote.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun VoteResult(
    ratio: Float,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "찬성"
                )
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(
                            color = Color.Magenta
                        )
                )
            }
            Box(
                modifier = Modifier
                    .height(20.dp)
                    .background(color = Color.Red)
                    .weight(1-ratio)
            )
            Box(
                modifier = Modifier
                    .height(20.dp)
                    .background(color = Color.Blue)
                    .weight(ratio)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "반대"
                )
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(
                            color = Color.Cyan
                        )
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun VoteResultPreview(){
    VoteResult(
        ratio = 0.5f,
    )
}