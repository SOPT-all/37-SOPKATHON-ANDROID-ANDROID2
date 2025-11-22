package com.example.sopkathon37android2.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.sopkathon37android2.R

object NotoSansFont {
    val medium = FontFamily(Font(R.font.notosans_medium))
    val semiBold = FontFamily(Font(R.font.notosans_semibold))
    val bold = FontFamily(Font(R.font.notosans_bold))
}

sealed interface TypographyTokens {

    @Immutable
    data class Header(
        val b_24 : TextStyle,
        val m_16 : TextStyle,
    )

    @Immutable
    data class Title(
        val sb_16: TextStyle,
        val sb_14: TextStyle,
    )

    @Immutable
    data class Body(
        val m_14: TextStyle,
        val m_13: TextStyle,
    )

    @Immutable
    data class Caption(
        val sb_12: TextStyle,
        val m_12: TextStyle,
        val m_10: TextStyle,
    )
}

@Immutable
data class Typography(
    val header: TypographyTokens.Header,
    val title: TypographyTokens.Title,
    val body: TypographyTokens.Body,
    val caption: TypographyTokens.Caption,
)

val defaultTypography = Typography(
    header = TypographyTokens.Header(
        b_24 = TextStyle(
            fontFamily = NotoSansFont.bold,
            fontSize = 24.sp,
            lineHeight = (24 * 1.5f).sp
        ),
        m_16 = TextStyle(
            fontFamily = NotoSansFont.medium,
            fontSize = 16.sp,
            lineHeight = (16 * 1.5f).sp
        )
    ),
    title = TypographyTokens.Title(
        sb_16 = TextStyle(
            fontFamily = NotoSansFont.semiBold,
            fontSize = 16.sp,
            lineHeight = (16 * 1.5f).sp
        ),
        sb_14 = TextStyle(
            fontFamily = NotoSansFont.semiBold,
            fontSize = 14.sp,
            lineHeight = (14 * 1.5f).sp
        )
    ),
    body = TypographyTokens.Body(
        m_14 = TextStyle(
            fontFamily = NotoSansFont.medium,
            fontSize = 14.sp,
            lineHeight = (14 * 1.5f).sp
        ),
        m_13 = TextStyle(
            fontFamily = NotoSansFont.medium,
            fontSize = 13.sp,
            lineHeight = (13 * 1.5f).sp
        )
    ),
    caption = TypographyTokens.Caption(
        sb_12 = TextStyle(
            fontFamily = NotoSansFont.semiBold,
            fontSize = 12.sp,
            lineHeight = (12 * 1.5f).sp
        ),
        m_12 = TextStyle(
            fontFamily = NotoSansFont.medium,
            fontSize = 12.sp,
            lineHeight = (12 * 1.5f).sp
        ),
        m_10 = TextStyle(
            fontFamily = NotoSansFont.medium,
            fontSize = 10.sp,
            lineHeight = (10 * 1.5f).sp
        )
    ),
)
