package com.sopt.sopkathon37android2.presentation.register.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = Color.DarkGray,
        modifier = modifier
            .padding(start = 4.dp, bottom = 4.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun TextFieldTitlePreview() {
    TextFieldTitle(
        text = "Text Field Title"
    )
}