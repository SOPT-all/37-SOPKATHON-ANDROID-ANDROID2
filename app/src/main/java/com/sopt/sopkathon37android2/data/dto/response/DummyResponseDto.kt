package com.sopt.sopkathon37android2.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class DummyResponseDto(
    @SerialName("nickname")
    val nickname: String
)
