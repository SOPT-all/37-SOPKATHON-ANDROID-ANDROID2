package com.sopt.sopkathon37android2.presentation.home

import com.sopt.sopkathon37android2.presentation.home.model.HomeTab
import com.sopt.sopkathon37android2.presentation.home.model.VoteUiModel

data class HomeState(
    val userId: Long = 0,
    val nickname: String = "",
    val selectedTab: HomeTab = HomeTab.ISSUE,
    val isActivated: Boolean = false,
    val isIssueSelected: Boolean = true,
    val isVoteSelected: Boolean = false,
    val voteList : List<VoteUiModel> = emptyList()
)
