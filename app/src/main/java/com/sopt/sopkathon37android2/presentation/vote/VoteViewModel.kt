package com.sopt.sopkathon37android2.presentation.vote

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.sopkathon37android2.data.dto.request.VoteRequestDto
import com.sopt.sopkathon37android2.data.service.VoteService
import com.sopt.sopkathon37android2.presentation.vote.state.VoteUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VoteViewModel @Inject constructor(
    private val voteService: VoteService,
) : ViewModel() {
    private val _uiState = MutableStateFlow(VoteUiState())
    val uiState: StateFlow<VoteUiState> = _uiState.asStateFlow()

    val issueId: Long = 1
    val userId: Long = 3

    init {
        getVote(1, 1)
    }

    fun setAgree(agree: Boolean){
        _uiState.update {
            it.copy(
                isAgreed = agree
            )
        }
    }

    fun voteAgree() {
        vote(issueId, userId, isAgree = true)
    }

    fun voteDisagree() {
        vote(issueId, userId, isAgree = false)
    }

    fun getVote(issueId: Long, userId: Long) {
        viewModelScope.launch {
            runCatching {
                voteService.getVote(
                    issueId = issueId,
                    userId = userId,
                )
            }.onSuccess { response ->
                val data = response.data
                _uiState.update {
                    it.copy(
                        title = data.title,
                        stage = data.college,
                        writer = data.department,
                        content = data.description,
                        imgList = data.imageUrl,
                        isVoted = data.isVoted,
                        isAgreed = data.isAgreed,
                        agreeVoter = data.agreeCount ?: 0,
                        disagreeVoter = data.disagreeCount ?: 0,
                        maxVoter = (data.agreeCount ?: 0) + (data.disagreeCount ?: 0),
                    )
                }
            }.onFailure {
                // 에러 처리 (필요시 로깅 또는 에러 상태 업데이트)
            }
        }
    }

    fun vote(issueId: Long, userId: Long, isAgree: Boolean) {
        viewModelScope.launch {
            runCatching {
                voteService.vote(
                    userId = userId,
                    issueId = issueId,
                    request = VoteRequestDto(isAgree = isAgree),
                )
            }.onSuccess { response ->
                // 투표 성공 후 최신 데이터 가져오기
                getVote(issueId, userId)
                _uiState.update {
                    it.copy(
                        isAgreed = isAgree,
                        isVoted = true
                    )
                }
            }.onFailure {
                // 에러 처리 (필요시 로깅 또는 에러 상태 업데이트)
            }
        }
    }
}
