package com.sopt.sopkathon37android2.data.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequestDto(
    val title: String,
    val description: String,
    val range: String
)