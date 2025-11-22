package com.sopt.sopkathon37android2.presentation.home.model

data class VoteUiModel(
    val id: Long,
    val title: String,
    val range: String,
    val department: String,
    val isCouncil: Boolean,
    val votedCount: Int,
)
