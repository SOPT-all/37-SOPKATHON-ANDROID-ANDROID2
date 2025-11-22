package com.sopt.sopkathon37android2.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponseDto(
    val status: Int,
    val message: String
)