package com.sopt.sopkathon37android2.presentation.home

import com.sopt.sopkathon37android2.presentation.home.component.TagType

data class IssueState(
    val isActivated: Boolean = false,
    val issueList: List<IssueItem> = emptyList()
)

data class IssueItem(
    val id: Long,
    val tag: String,
    val tagType: TagType,
    val dDay: String,
    val title: String,
    val author: String,
    val boomUpCount: String,
    val isBoomUpFilled: Boolean
)
