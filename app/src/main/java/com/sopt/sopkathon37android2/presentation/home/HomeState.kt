package com.sopt.sopkathon37android2.presentation.home

import com.sopt.sopkathon37android2.presentation.home.model.HomeTab

data class HomeState(
    val userId: Long = 0,
    val nickname: String = "",
    val isSelected: Boolean = false,
    val selectedTab: HomeTab = HomeTab.ISSUE
)
