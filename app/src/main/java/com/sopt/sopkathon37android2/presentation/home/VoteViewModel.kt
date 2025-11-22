package com.sopt.sopkathon37android2.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.sopkathon37android2.data.mapper.toUiModel
import com.sopt.sopkathon37android2.data.service.VoteService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VoteViewModel @Inject constructor(
    private val voteService: VoteService,
) : ViewModel() {
    private val _uiState = MutableStateFlow(VoteState())
    val uiState: StateFlow<VoteState> = _uiState.asStateFlow()

    init {
        println("뷰모델 실행됨")
        getVoteList()
    }

    private fun getVoteList() {
        viewModelScope.launch {
            runCatching {
                voteService.getVoteListsService()
            }.onSuccess { response ->
                val uiList = response.data.map { it.toUiModel() }
                _uiState.value= _uiState.value.copy(
                    voteList = uiList
                )
            }.onFailure { e ->
            }
        }
    }
}
