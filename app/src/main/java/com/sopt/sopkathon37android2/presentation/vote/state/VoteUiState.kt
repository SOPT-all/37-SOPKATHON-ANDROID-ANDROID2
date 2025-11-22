package com.sopt.sopkathon37android2.presentation.vote.state

data class VoteUiState(
    val title: String = "ㅁㅁㅁ",
    val stage: String = "ㅁㅁㅁㅁ",
    val writer: String = "ㅁㅁㅁㅁ",
    val content: String = "ㅁㅁㅁㅁㅁ",
    val imgList: List<String>? = listOf(),
    val isVoted: Boolean = true,
    val isAgreed: Boolean = false,
    val maxVoter: Int = 100,
    val agreeVoter: Int = 30,
    val disagreeVoter: Int = 70,
)