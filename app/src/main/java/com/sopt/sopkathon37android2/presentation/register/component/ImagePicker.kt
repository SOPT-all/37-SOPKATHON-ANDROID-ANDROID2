package com.sopt.sopkathon37android2.presentation.register.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sopkathon37android2.R
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme
import com.sopt.sopkathon37android2.core.util.noRippleClickable

@Composable
fun ImagePicker(
    onAddClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(SopkathonTheme.colors.white)
            .noRippleClickable { onAddClick() }
            .border(
                width = 1.dp,
                color = SopkathonTheme.colors.gray02,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(17.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_plus),
            contentDescription = null,
            tint = SopkathonTheme.colors.gray03,
            modifier = Modifier
                .size(24.dp)
        )
    }
}

@Composable
fun ImagePickerRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ImagePicker(
            onAddClick = {}
        )
        repeat(2) {
            Box(
                modifier = Modifier
                    .size(58.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(SopkathonTheme.colors.gray02)
                    .border(
                        width = 1.dp,
                        color = SopkathonTheme.colors.gray02,
                        shape = RoundedCornerShape(4.dp)
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ImagePickerRowPreview() {
    ImagePickerRow()
}