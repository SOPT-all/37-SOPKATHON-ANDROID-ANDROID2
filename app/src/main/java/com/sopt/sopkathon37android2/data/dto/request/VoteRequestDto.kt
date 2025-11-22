package com.sopt.sopkathon37android2.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VoteRequestDto(
    @SerialName("isAgree")
    val isAgree: Boolean,
)