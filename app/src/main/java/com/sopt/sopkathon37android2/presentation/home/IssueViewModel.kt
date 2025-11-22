package com.sopt.sopkathon37android2.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.sopkathon37android2.data.service.IssueScreenService
import com.sopt.sopkathon37android2.data.service.RecommendService
import com.sopt.sopkathon37android2.presentation.home.component.TagType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IssueViewModel @Inject constructor(
    private val issueService: IssueScreenService,
    private val recommendService: RecommendService,
) : ViewModel() {
    private val _uiState = MutableStateFlow(IssueState())
    val uiState: StateFlow<IssueState> = _uiState.asStateFlow()

    companion object {
        private const val TAG = "IssueViewModel"
    }

    init {
        loadIssues()
    }

    private fun loadIssues() {
        viewModelScope.launch {
            try {
                val currentState = _uiState.value
                val range = if (currentState.isActivated) "department" else "all"

                Log.d(TAG, "API 호출 - range: $range")

                val response = issueService.getIssues(
                    userId = 1L,
                    range = range,
                    order = "recommend"
                )

                Log.d(TAG, "API 응답 - status: ${response.status}")

                if (response.status == 200) {
                    val issueItems = response.data?.map { issue ->
                        IssueItem(
                            id = issue.issueId,
                            tag = issue.range,
                            tagType = when (issue.range) {
                                "전체" -> TagType.ALL
                                "단과대학" -> TagType.MY
                                "학과" -> TagType.OTHER
                                else -> TagType.ALL
                            },
                            dDay = "D-${issue.remainedDay}",
                            title = issue.title,
                            author = "${issue.department} 학생회",
                            boomUpCount = issue.recommendCount.toString(),
                            isBoomUpFilled = false
                        )
                    } ?: emptyList()

                    _uiState.update {
                        it.copy(issueList = issueItems)
                    }

                    Log.d(TAG, "UI 업데이트 완료 - ${issueItems.size}개 아이템")
                }
            } catch (e: Exception) {
                Log.e(TAG, "loadIssues 에러", e)
            }
        }
    }

    fun onToggleClicked() {
        _uiState.update {
            it.copy(isActivated = !it.isActivated)
        }
        loadIssues() // 토글 시 데이터 재로드
    }

    fun postRecommend(issueId: Long) {
        viewModelScope.launch {
            try {
                val response = recommendService.postRecommend(
                    userId = 1L,
                    issueId = issueId
                )

                if (response.status == 201) {
                    Log.d("Recommend", "추천 성공: ${response.message}")

                    // 추천 카운트 증가시키기 (Optional)
                    updateIssueRecommendCount(issueId)
                }
            } catch (e: Exception) {
                Log.e("Recommend", "추천 실패", e)
            }
        }
    }

    private fun updateIssueRecommendCount(issueId: Long) {
        _uiState.update { state ->
            val updatedList = state.issueList.map { item ->
                if (item.id == issueId) {
                    item.copy(
                        boomUpCount = (item.boomUpCount.toInt() + 1).toString(),
                        isBoomUpFilled = true
                    )
                } else item
            }
            state.copy(issueList = updatedList)
        }
    }
}