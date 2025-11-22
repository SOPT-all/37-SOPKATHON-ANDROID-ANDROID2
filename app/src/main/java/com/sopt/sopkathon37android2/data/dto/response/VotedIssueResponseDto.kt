package com.sopt.sopkathon37android2.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class VotedIssueResponseDto(
    val id: Int,
    val title: String,
    val range: String,
    val department: String,
    val votedCount: Int,
    val isCouncil: Boolean
)