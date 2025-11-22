package com.sopt.sopkathon37android2.presentation.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun HomeBanner(
    @DrawableRes bannerImage: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = bannerImage),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .padding()
            .fillMaxWidth()
            .height(130.dp)
            .clip(RoundedCornerShape(8.dp)),
    )
}
