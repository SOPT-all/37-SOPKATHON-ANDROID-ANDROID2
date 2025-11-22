package com.sopt.sopkathon37android2.presentation.register.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme
import com.sopt.sopkathon37android2.core.util.noRippleClickable

@Composable
fun SelectableChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(
                if (isSelected)
                    SopkathonTheme.colors.keyLight
                else
                    SopkathonTheme.colors.white
            )
            .then(
                if (isSelected) {
                    Modifier.border(
                        width = 1.dp,
                        color = SopkathonTheme.colors.keyLight,
                        shape = RoundedCornerShape(4.dp)
                    )
                } else {
                    Modifier.border(
                        width = 1.dp,
                        color = SopkathonTheme.colors.gray02,
                        shape = RoundedCornerShape(4.dp)
                    )
                }
            )
            .noRippleClickable { onClick() }
            .padding(vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = SopkathonTheme.typography.caption.m_12,
            color = if (isSelected) SopkathonTheme.colors.gray05 else SopkathonTheme.colors.gray04
        )
    }
}

@Composable
fun SelectableChipRow(
    chips: List<String>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        chips.forEachIndexed { index, text ->
            SelectableChip(
                text = text,
                isSelected = selectedIndex == index,
                onClick = { onSelect(index) },
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SelectableChipRowPreview() {
    var selectedIndex by remember { mutableIntStateOf(-1) }

    SelectableChipRow(
        chips = listOf("학교 전체", "단과대", "학과"),
        selectedIndex = selectedIndex,
        onSelect = { index -> selectedIndex = index }
    )
}