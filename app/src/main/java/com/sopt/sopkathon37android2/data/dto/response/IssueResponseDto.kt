package com.sopt.sopkathon37android2.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class IssueResponseDto(
    val title: String,
    val college: String,
    val recommendCount: Int,
    val range: String,
    val department: String,
    val remainedDay: Int,
    val isBest: Boolean
)