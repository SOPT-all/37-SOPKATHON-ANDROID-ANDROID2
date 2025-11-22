package com.sopt.sopkathon37android2.presentation.vote.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun VoteDialog(
    onDismiss: () -> Unit = {},
    onConfirm: () -> Unit = {},
) {
    Dialog(
        onDismissRequest = onDismiss,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
        ) {
            Text(
                text = "진짜 손 드시겠습니까?"
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
            ) {
               Text(
                   text = "취소",
                   textAlign = TextAlign.Center,
                   modifier = Modifier
                       .wrapContentSize(Alignment.Center)
                       .clickable(
                           onClick = onDismiss
                       )
               )
                Text(
                    text = "손들기",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .clickable(
                            onClick = onConfirm
                        )
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun VoteDialogPreview(){
    VoteDialog()
}