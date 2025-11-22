package com.sopt.sopkathon37android2.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.sopkathon37android2.data.dto.request.RegisterRequestDto
import com.sopt.sopkathon37android2.data.service.RegisterService
import com.sopt.sopkathon37android2.presentation.register.navigation.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerService: RegisterService,
) : ViewModel(){
    private val _uiState = MutableStateFlow(RegisterState())
    val uiState: StateFlow<RegisterState> = _uiState.asStateFlow()

    private val _navigateToHome = MutableSharedFlow<Unit>()
    val navigateToHome = _navigateToHome.asSharedFlow()

    fun onRegisterButtonClicked() {
        val state = uiState.value

        val request = RegisterRequestDto(
            title = state.title,
            description = state.content,
            range = when (state.selectedIndex) {
                0 -> "ALL"
                1 -> "COLLEGE"
                2 -> "DEPARTMENT"
                else -> "ALL"
            }
        )
        viewModelScope.launch {
            try {
                val response = registerService.postRegister(
                    userId = 1L,
                    request = request
                )
                println("성공: ${response.message}")

                _navigateToHome.emit(Unit)
            } catch (e: Exception) {
                println("에러: $e")
            }
        }
    }

    fun updateText(title: String) {
        _uiState.update {
            it.copy(
                title = title
            )
        }
        onButtonEnabled()
    }

    fun updateContent(content: String) {
        _uiState.update {
            it.copy(
                content = content
            )
        }
        onButtonEnabled()
    }

    fun updateSelectedIndex(index: Int) {
        _uiState.update {
            it.copy(
                selectedIndex = index
            )
        }
        onButtonEnabled()
    }

    private fun onButtonEnabled() {
        val state = uiState.value
        if (state.title.isNotEmpty() && state.content.isNotEmpty() && state.selectedIndex != -1){
            _uiState.update {
                it.copy(
                    isButtonEnabled = true
                )
            }
        }
    }
}
