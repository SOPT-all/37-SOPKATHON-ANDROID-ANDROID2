package com.sopt.sopkathon37android2.presentation.register.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sopkathon37android2.R
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme
import com.sopt.sopkathon37android2.core.util.noRippleClickable

@Composable
fun TopBar(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .noRippleClickable { onBackClick() }

        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = title,
            color = SopkathonTheme.colors.black,
            style = SopkathonTheme.typography.header.m_16
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TopBarPreview() {
    TopBar(
        title = "안건 등록하기",
        onBackClick = {}
    )
}