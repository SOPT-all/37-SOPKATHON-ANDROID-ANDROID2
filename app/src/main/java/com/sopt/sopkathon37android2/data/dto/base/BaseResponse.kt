package com.sopt.sopkathon37android2.data.dto.base

data class BaseResponse<T>(
    val status: Int,
    val message: String,
    val data: T? = null
)