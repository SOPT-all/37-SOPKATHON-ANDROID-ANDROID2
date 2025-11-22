package com.sopt.sopkathon37android2.core.designsystem.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color

val White = Color(0xFFFFFFFF)

val Gray01 = Color(0xFFF8F9FB)
val Gray02 = Color(0xFFE4E8F2)
val Gray03 = Color(0xFFC3C7D1)
val Gray04 = Color(0xFF687393)
val Gray05 = Color(0xFF3F475B)

val Black = Color(0xFF000000)

val DisArg01 = Color(0xFFFF4F93)
val Arg01 = Color(0xFF1C6EE9)

val KeyLight = Color(0xFFFFC0D9)
val KeyDark = Color(0xFFFF78B0)

val TagAll = Color(0xFFADC4FF)
val TagMy = Color(0xFFD1DEFF)
val TagOther = Color(0xFFE4E8F2)

@Immutable
data class Colors(
    val white: Color = White,
    val black: Color = Black,

    val gray01: Color = Gray01,
    val gray02: Color = Gray02,
    val gray03: Color = Gray03,
    val gray04: Color = Gray04,
    val gray05: Color = Gray05,

    val disArg01: Color = DisArg01,
    val arg01: Color = Arg01,

    val keyLight: Color = KeyLight,
    val keyDark: Color = KeyDark,

    val tagAll: Color = TagAll,
    val tagMy: Color = TagMy,
    val tagOther: Color = TagOther
)

val defaultColors = Colors()
