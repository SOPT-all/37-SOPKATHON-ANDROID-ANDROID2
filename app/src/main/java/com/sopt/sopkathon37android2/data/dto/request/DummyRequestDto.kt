package com.sopt.sopkathon37android2.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyRequestDto(
    @SerialName("id")
    val id: Int,
    @SerialName("email")
    val email: String,
)
