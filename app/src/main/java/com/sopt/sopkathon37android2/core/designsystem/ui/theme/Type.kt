package com.example.sopkathon37android2.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.sopkathon37android2.R

object NotoSansFont {
    val light = FontFamily(Font(R.font.notosans_light))
    val medium = FontFamily(Font(R.font.notosans_medium))
    val regular = FontFamily(Font(R.font.notosans_regular))
    val semiBold = FontFamily(Font(R.font.notosans_semibold))
}

sealed interface TypographyTokens {
    @Immutable
    data class Title(
        val sb_26: TextStyle, // title_sb_26
        val m_24: TextStyle,  // title_m_24
        val r_20: TextStyle,  // title_r_20
        val m_18: TextStyle,  // title_m_18
        val m_16: TextStyle,  // title_m_16
        val l_16: TextStyle,  // title_l_16
    )

    @Immutable
    data class Body(
        val sb_15: TextStyle, // body_sb_15
        val r_15: TextStyle,  // body_r_15
        val sb_13: TextStyle, // body_sb_13
        val r_13: TextStyle,  // body_r_13
    )

    @Immutable
    data class Caption(
        val m_12: TextStyle,  // caption_m_12
        val r_12: TextStyle,  // caption_r_12
        val l_12: TextStyle,  // caption_l_12
        val sb_11: TextStyle, // caption_sb_11
        val l_11: TextStyle,  // caption_l_11
        val l_10: TextStyle,  // caption_l_10
        val r_9: TextStyle,   // caption_r_9
    )
}

@Immutable
data class Typography(
    val title: TypographyTokens.Title,
    val body: TypographyTokens.Body,
    val caption: TypographyTokens.Caption,
)

val defaultTypography = Typography(
    title = TypographyTokens.Title(
        sb_26 = TextStyle(
            fontFamily = NotoSansFont.semiBold,
            fontSize = 26.sp,
            lineHeight = (26 * 1.5f).sp
        ),
        m_24 = TextStyle(
            fontFamily = NotoSansFont.medium,
            fontSize = 24.sp,
            lineHeight = (24 * 1.5f).sp
        ),
        r_20 = TextStyle(
            fontFamily = NotoSansFont.regular,
            fontSize = 20.sp,
            lineHeight = (20 * 1.5f).sp
        ),
        m_18 = TextStyle(
            fontFamily = NotoSansFont.medium,
            fontSize = 18.sp,
            lineHeight = (18 * 1.5f).sp
        ),
        m_16 = TextStyle(
            fontFamily = NotoSansFont.medium,
            fontSize = 16.sp,
            lineHeight = (16 * 1.5f).sp
        ),
        l_16 = TextStyle(
            fontFamily = NotoSansFont.light,
            fontSize = 16.sp,
            lineHeight = (16 * 1.5f).sp
        ),
    ),
    body = TypographyTokens.Body(
        sb_15 = TextStyle(
            fontFamily = NotoSansFont.semiBold,
            fontSize = 15.sp,
            lineHeight = (15 * 1.5f).sp
        ),
        r_15 = TextStyle(
            fontFamily = NotoSansFont.regular,
            fontSize = 15.sp,
            lineHeight = (15 * 1.5f).sp
        ),
        sb_13 = TextStyle(
            fontFamily = NotoSansFont.semiBold,
            fontSize = 13.sp,
            lineHeight = (13 * 1.5f).sp
        ),
        r_13 = TextStyle(
            fontFamily = NotoSansFont.regular,
            fontSize = 13.sp,
            lineHeight = (13 * 1.5f).sp
        ),
    ),
    caption = TypographyTokens.Caption(
        m_12 = TextStyle(
            fontFamily = NotoSansFont.medium,
            fontSize = 12.sp,
            lineHeight = (12 * 1.5f).sp
        ),
        r_12 = TextStyle(
            fontFamily = NotoSansFont.regular,
            fontSize = 12.sp,
            lineHeight = (12 * 1.5f).sp
        ),
        l_12 = TextStyle(
            fontFamily = NotoSansFont.light,
            fontSize = 12.sp,
            lineHeight = (12 * 1.5f).sp
        ),
        sb_11 = TextStyle(
            fontFamily = NotoSansFont.semiBold,
            fontSize = 11.sp,
            lineHeight = (11 * 1.5f).sp
        ),
        l_11 = TextStyle(
            fontFamily = NotoSansFont.light,
            fontSize = 11.sp,
            lineHeight = (11 * 1.5f).sp
        ),
        l_10 = TextStyle(
            fontFamily = NotoSansFont.light,
            fontSize = 10.sp,
            lineHeight = (10 * 1.5f).sp
        ),
        r_9 = TextStyle(
            fontFamily = NotoSansFont.regular,
            fontSize = 9.sp,
            lineHeight = (9 * 1.6f).sp
        ),
    ),
)