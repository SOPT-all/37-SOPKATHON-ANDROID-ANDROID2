package com.sopt.sopkathon37android2.presentation.register.navigation

data class RegisterState(
    val title: String = "",
    val content: String = "",
    val selectedIndex: Int = -1,
    val isButtonEnabled: Boolean = false
)