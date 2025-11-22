package com.sopt.sopkathon37android2.presentation.home.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.sopkathon37android2.R
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme

@Composable
fun HomeToggle(
    isActivated: Boolean,
    onToggleClick: () -> Unit,
    modifier: Modifier = Modifier
){
    val toggleColor = if (isActivated) SopkathonTheme.colors.keyLight else SopkathonTheme.colors.gray04

    val biasX by animateFloatAsState(
        targetValue = if (isActivated) 1f else -1f,
        label = "toggleBias"
    )
    val toggleAlignment = BiasAlignment(
        horizontalBias = biasX,
        verticalBias = 0f
    )

    Box(
        modifier = modifier
    ){
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_toggle_bar),
            contentDescription = null,
            modifier = Modifier
                .size(width = 19.dp, height = 5.dp)
                .align(alignment = Alignment.Center),
            tint = Color.Unspecified
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_toggle_circle),
            contentDescription = null,
            modifier = Modifier
                .size(11.dp)
                .align(alignment = toggleAlignment)
                .clickable(onClick = onToggleClick),
            tint = toggleColor
        )
    }
}
