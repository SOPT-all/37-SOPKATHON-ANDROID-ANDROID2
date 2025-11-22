package com.sopt.sopkathon37android2.data.mapper

import com.sopt.sopkathon37android2.data.dto.response.VoteResponseDto
import com.sopt.sopkathon37android2.presentation.home.model.VoteUiModel

fun VoteResponseDto.toUiModel(): VoteUiModel =
    VoteUiModel(
        id = id,
        title = title,
        range = range,
        department = department,
        isCouncil = isCouncil,
        votedCount = votedCount
    )
