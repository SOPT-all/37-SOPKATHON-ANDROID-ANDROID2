package com.sopt.sopkathon37android2.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VoteResponseDto(
    @SerialName("id")
    val id: Long,
    @SerialName("title")
    val title: String,
    @SerialName("range")
    val range: String,
    @SerialName("department")
    val department: String,
    @SerialName("votedCount")
    val votedCount: Int,
    @SerialName("isCouncil")
    val isCouncil: Boolean
)

@Serializable
data class VoteBaseResponseDto<T>(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: T,
)
