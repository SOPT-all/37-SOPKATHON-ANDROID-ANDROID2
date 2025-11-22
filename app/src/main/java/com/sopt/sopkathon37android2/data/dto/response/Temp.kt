package com.sopt.sopkathon37android2.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VoteResponseDto2(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("department")
    val department: String,
    @SerialName("votedCount")
    val votedCount: Int,
    @SerialName("isCouncil")
    val isCouncil: Boolean
)

@Serializable
data class VoteBaseResponseDto2<T>(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: T,
)
