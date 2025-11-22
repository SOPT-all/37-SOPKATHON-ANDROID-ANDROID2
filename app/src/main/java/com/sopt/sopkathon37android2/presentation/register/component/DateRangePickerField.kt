package com.sopt.sopkathon37android2.presentation.register.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DateRangePickerField(
    modifier: Modifier = Modifier
) {
    val startDate = LocalDate.now()
    val endDate = startDate.plusDays(21)
    val formatter = DateTimeFormatter.ofPattern("MM/dd")
    val dateRangeText = "${startDate.format(formatter)} ~ ${endDate.format(formatter)}"

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(SopkathonTheme.colors.white)
            .border(
                width = 1.dp,
                color = SopkathonTheme.colors.gray02,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = dateRangeText,
            style = SopkathonTheme.typography.body.m_13,
            color = SopkathonTheme.colors.gray04,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DateRangePickerFieldPreview() {
    DateRangePickerField()
}