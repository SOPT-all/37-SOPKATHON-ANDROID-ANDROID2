package com.example.sopkathon37android2.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val White = Color(0xFFFFFFFF)
val Gray100 = Color(0xFFF4F4F4)
val Gray200 = Color(0xFFDADADA)
val Gray300 = Color(0xFF949494)
val Gray400 = Color(0xFF767676)
val Gray600 = Color(0xFF6A6A6A)
val Gray900 = Color(0xFF141414)
val Black = Color(0xFF000000)
val Black_50 = Color(0xFF000000).copy(alpha = 0.5f)

val BrandRed = Color(0xFFDF080D)

@Immutable
data class Colors(
    val white: Color = White,
    val black: Color = Black,

    val brandRed: Color = BrandRed,

    val gray100: Color = Gray100,
    val gray200: Color = Gray200,
    val gray300: Color = Gray300,
    val gray400: Color = Gray400,
    val gray600: Color = Gray600,
    val gray900: Color = Gray900,
    val black50: Color = Black_50,
)

val defaultColors = Colors()