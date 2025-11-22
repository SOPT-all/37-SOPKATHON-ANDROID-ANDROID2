package com.sopt.sopkathon37android2.presentation.vote

import androidx.lifecycle.ViewModel
import com.sopt.sopkathon37android2.data.service.DummyService
import com.sopt.sopkathon37android2.presentation.vote.state.VoteUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class VoteViewModel @Inject constructor(
    private val dummyService: DummyService,
) : ViewModel() {
    private val _uiState = MutableStateFlow(VoteUiState())
    val uiState: StateFlow<VoteUiState> = _uiState.asStateFlow()
}
