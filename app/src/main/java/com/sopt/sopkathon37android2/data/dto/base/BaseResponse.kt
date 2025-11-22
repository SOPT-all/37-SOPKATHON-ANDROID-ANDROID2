package com.sopt.sopkathon37android2.data.dto.base

import kotlinx.serialization.Serializable


@Serializable
data class BaseResponse<T>(
    val status: Int,
    val message: String,
    val data: T? = null
)

@Serializable
data class NonNullBaseResponse<T>(
    val status: Int,
    val message: String,
    val data: T
)