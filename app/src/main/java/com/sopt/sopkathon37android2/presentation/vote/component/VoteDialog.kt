package com.sopt.sopkathon37android2.presentation.vote.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme

@Composable
fun VoteDialog(
    isAgreed: Boolean = false,
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
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(all = 16.dp)
        ) {
            Text(
                text = if (isAgreed) {
                    "정말 찬성하시겠습니까?"
                } else {
                    "정말 반대하시겠습니까?"
                },
                color = SopkathonTheme.colors.gray05,
                style = SopkathonTheme.typography.body.m_14,
                modifier = Modifier
                    .padding(horizontal = 54.dp, vertical = 28.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                DialogButton(
                    text = "취소",
                    textColor = SopkathonTheme.colors.gray04,
                    onclick = onDismiss,
                    modifier = Modifier
                        .weight(1f)
                )
                DialogButton(
                    text = if (isAgreed) {
                        "찬성"
                    } else {
                        "반대"
                    },
                    textColor = SopkathonTheme.colors.gray05,
                    backgroundColor = SopkathonTheme.colors.keyLight,
                    onclick = onConfirm,
                    modifier = Modifier
                        .weight(1f)
                )

            }
        }
    }
}

@Composable
fun DialogButton(
    text: String = "취소",
    onclick: () -> Unit,
    textColor: Color = Color.Black,
    backgroundColor: Color = Color.White,
    modifier: Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(horizontal = 49.dp, vertical = 15.dp)
            .clickable(
                onClick = onclick
            ),
    ) {
        Text(
            text = text,
            color = textColor,
            style = SopkathonTheme.typography.body.m_14,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun VoteDialogPreview() {
    VoteDialog()
}

@Composable
@Preview(showBackground = true)
private fun DialogButtonPreview() {
    DialogButton(
        text = "성공",
        onclick = {},
        modifier = Modifier
    )
}