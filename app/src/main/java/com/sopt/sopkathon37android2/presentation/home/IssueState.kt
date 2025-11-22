package com.sopt.sopkathon37android2.presentation.home

import com.sopt.sopkathon37android2.presentation.home.component.TagType

data class IssueState(
    val isActivated: Boolean = false,
    val issueList: List<IssueItem> = emptyList(),
    val bestIssue: BestIssueItem? = null // 베스트 이슈 추가
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


data class BestIssueItem(
    val tag: String,
    val tagType: TagType,
    val dDay: String,
    val title: String,
    val author: String,
    val currentCount: Int,
    val maxCount: Int,
    val progressText: String
)