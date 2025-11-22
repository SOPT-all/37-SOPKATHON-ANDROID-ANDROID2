package com.sopt.sopkathon37android2.presentation.a

import com.sopt.sopkathon37android2.presentation.a.model.HomeTab

data class AState(
    val userId: Long = 0,
    val nickname: String = "",
    val isSelected: Boolean = false,
    val selectedTab: HomeTab = HomeTab.AGENDA
)
