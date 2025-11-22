package com.sopt.sopkathon37android2.presentation.home

import androidx.lifecycle.ViewModel
import com.sopt.sopkathon37android2.data.service.DummyService
import com.sopt.sopkathon37android2.presentation.home.component.TagType
import com.sopt.sopkathon37android2.presentation.home.model.VoteUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class VoteViewModel @Inject constructor(
    private val dummyService: DummyService,
) : ViewModel() {
    private val _uiState = MutableStateFlow(VoteState())
    val uiState: StateFlow<VoteState> = _uiState.asStateFlow()

    init {
        val dummyVotes = listOf(
            VoteUiModel(
                id = 1L,
                detailGroupTag = "총학생회",
                tagType = TagType.MY,
                studentCouncil = true,
                voteTotalNumber = 123,
                detailTitle = "중앙도서관 24시간 개방",
                detailGroup = "시험기간 야간 학습 공간 확대"
            ),
            VoteUiModel(
                id = 2L,
                detailGroupTag = "단과대",
                tagType = TagType.ALL,
                studentCouncil = false,
                voteTotalNumber = 87,
                detailTitle = "휴게실 전자레인지 추가 설치",
                detailGroup = "공학관 휴게실 환경 개선"
            )
        )
        _uiState.value = _uiState.value.copy(
            voteList = dummyVotes
        )

    }
}
