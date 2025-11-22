package com.sopt.sopkathon37android2.data.dto.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class VoteResponseDto(
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val status: Int
)


