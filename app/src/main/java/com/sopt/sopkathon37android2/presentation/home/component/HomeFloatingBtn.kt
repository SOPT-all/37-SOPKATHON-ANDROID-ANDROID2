package com.sopt.sopkathon37android2.presentation.home.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme

@Composable
fun HomeFloatingButton(
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = SopkathonTheme.colors.gray04,
        contentColor = SopkathonTheme.colors.white,
        shape = RoundedCornerShape(99.dp),
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "안건 등록하기",
                style = SopkathonTheme.typography.title.sb_14
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeFloatingButtonPreview() {
    SopkathonTheme {
        HomeFloatingButton {}
    }
}