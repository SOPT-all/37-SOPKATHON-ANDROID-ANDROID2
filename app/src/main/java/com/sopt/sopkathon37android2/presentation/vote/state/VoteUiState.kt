package com.sopt.sopkathon37android2.presentation.vote.state

data class VoteUiState(
    val title: String = "",
    val stage: String = "",
    val writer: String = "",
    val content: String = "",
    val imgList: List<String>? = null,
    val isVotingOpen: Boolean = true,
    val ratio: Float? = 0f,
)