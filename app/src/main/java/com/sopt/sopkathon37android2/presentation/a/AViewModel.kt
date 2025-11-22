package com.sopt.sopkathon37android2.presentation.a

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.sopkathon37android2.data.service.DummyService
import com.sopt.sopkathon37android2.presentation.a.model.HomeTab
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AViewModel @Inject constructor(
    private val dummyService: DummyService,
) : ViewModel() {
    private val _uiState = MutableStateFlow(AState())
    val uiState: StateFlow<AState> = _uiState.asStateFlow()

    fun getDummy() {
        viewModelScope.launch {
            runCatching {
                dummyService.getDummies(uiState.value.userId)
            }.onSuccess {
                _uiState.value =
                    _uiState.value.copy(
                        nickname = it.data.nickname,
                    )
            }.onFailure {
            }
        }
    }

    fun onAgendaClicked() {
        _uiState.update {
            it.copy(
                selectedTab = HomeTab.ISSUE
            )
        }
    }

    fun onVoteClicked() {
        _uiState.update {
            it.copy(
                selectedTab = HomeTab.VOTE
            )
        }
    }
}
