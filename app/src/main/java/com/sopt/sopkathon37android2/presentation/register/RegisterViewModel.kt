package com.sopt.sopkathon37android2.presentation.register

import androidx.lifecycle.ViewModel
import com.sopt.sopkathon37android2.data.service.DummyService
import com.sopt.sopkathon37android2.presentation.register.navigation.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val dummyService: DummyService,
) : ViewModel(){
    private val _uiState = MutableStateFlow(RegisterState())
    val uiState: StateFlow<RegisterState> = _uiState.asStateFlow()

    fun onRegisterButtonClicked(){
        //TODO: 서버연결
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
