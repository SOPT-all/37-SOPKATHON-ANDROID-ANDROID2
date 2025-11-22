package com.sopt.sopkathon37android2.presentation.home.model

import com.sopt.sopkathon37android2.presentation.home.component.TagType

data class VoteUiModel(
    val id: Long,
    val detailGroupTag: String,
    val tagType: TagType,
    val studentCouncil: Boolean,
    val voteTotalNumber: Int,
    val detailTitle: String,
    val detailGroup: String,
)
