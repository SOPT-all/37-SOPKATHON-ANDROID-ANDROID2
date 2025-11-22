package com.sopt.sopkathon37android2.presentation.vote.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun VoteButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    Row {
        AsyncImage(
            model = "",
            contentDescription = null,
            modifier = modifier.clickable(onClick = onClick),
        )
        Column {
            Text(
                text = text
            )
            Text(
                text = "손들기"
            )
        }
    }
}