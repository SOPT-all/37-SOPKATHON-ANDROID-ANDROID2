package com.sopt.sopkathon37android2.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.sopkathon37android2.data.service.IssueScreenService
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
) : ViewModel() {
    private val _uiState = MutableStateFlow(IssueState())
    val uiState: StateFlow<IssueState> = _uiState.asStateFlow()

    companion object {
        private const val TAG = "IssueViewModel"
    }

    init {
        loadIssues()
        loadBestIssue() // 베스트 이슈도 로드
    }
    private fun loadBestIssue() {
        viewModelScope.launch {
            try {
                Log.d(TAG, "베스트 이슈 API 호출")

                val response = issueService.getBestIssue()

                Log.d(TAG, "베스트 이슈 API 응답 - status: ${response.status}")

                if (response.status == 200 && response.data != null) {
                    val bestIssue = response.data.let { issue ->
                        BestIssueItem(
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
                            currentCount = 25, // API에 없어서 임시값
                            maxCount = 50,     // API에 없어서 임시값
                            progressText = "투표 가능까지 1명 남았어요" // 임시값
                        )
                    }

                    _uiState.update {
                        it.copy(bestIssue = bestIssue)
                    }

                    Log.d(TAG, "베스트 이슈 UI 업데이트 완료")
                }
            } catch (e: Exception) {
                Log.e(TAG, "베스트 이슈 로드 에러", e)
            }
        }
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
                            id = issue.title,
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
}