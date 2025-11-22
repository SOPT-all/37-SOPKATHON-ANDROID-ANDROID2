package com.sopt.sopkathon37android2.presentation.home

import androidx.lifecycle.ViewModel
import com.sopt.sopkathon37android2.data.service.DummyService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class IssueViewModel @Inject constructor(
    private val dummyService: DummyService,
) : ViewModel() {
    private val _uiState = MutableStateFlow(IssueState())
    val uiState: StateFlow<IssueState> = _uiState.asStateFlow()

    fun onToggleClicked() {
        _uiState.update {
            it.copy(
                isActivated = !it.isActivated
            )
        }
    }
}
