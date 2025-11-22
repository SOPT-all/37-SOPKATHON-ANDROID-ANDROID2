package com.sopt.sopkathon37android2.presentation.home

import com.sopt.sopkathon37android2.presentation.home.component.TagType
import com.sopt.sopkathon37android2.presentation.home.model.HomeTab
import com.sopt.sopkathon37android2.presentation.home.model.VoteUiModel

data class HomeState(
    val userId: Long = 0,
    val nickname: String = "",
    val selectedTab: HomeTab = HomeTab.ISSUE,
    val isActivated: Boolean = false,
    val isIssueSelected: Boolean = true,
    val isVoteSelected: Boolean = false,
    val voteList : List<VoteUiModel> = emptyList(),
    val issueList: List<IssueItem> = emptyList()
)

data class IssueItem(
    val id: String,
    val tag: String,
    val tagType: TagType,
    val dDay: String,
    val title: String,
    val author: String,
    val boomUpCount: String,
    val isBoomUpFilled: Boolean
)