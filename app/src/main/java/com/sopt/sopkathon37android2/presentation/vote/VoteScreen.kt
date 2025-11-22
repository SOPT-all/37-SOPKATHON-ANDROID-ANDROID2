package com.sopt.sopkathon37android2.presentation.vote

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.sopt.sopkathon37android2.presentation.vote.component.VoteButton
import com.sopt.sopkathon37android2.presentation.vote.component.VoteDialog
import com.sopt.sopkathon37android2.presentation.vote.component.VoteResult
import com.sopt.sopkathon37android2.presentation.vote.component.VoteStage
import com.sopt.sopkathon37android2.presentation.vote.state.VoteUiState

@Composable
fun VoteRoute(
    paddingValues: PaddingValues,
    onNavigateToHome: () -> Unit,
    viewModel: VoteViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    VoteScreen(
        uiState = uiState,
        onClick = onNavigateToHome,
        paddingValues = paddingValues,
    )
}

@Composable
private fun VoteScreen(
    uiState: VoteUiState,
    paddingValues: PaddingValues,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    onClickVote: () -> Unit = {},
) {
    val openDialog = remember {
        mutableStateOf(false)
    }
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
    ) {
        //탑 바 추가
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = uiState.title)
                VoteStage()
                Spacer(modifier = Modifier.weight(1f))
                Text(text = uiState.writer)
            }
            Spacer(modifier = Modifier.height(height = 20.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                item {
                    Text(
                        text = uiState.content
                    )
                }
            }
            uiState.imgList?.forEach { imgUrl ->
                AsyncImage(
                    model = imgUrl,
                    contentDescription = null
                )
            }
            Text(
                text = "ㅇㅇㅇㅇ",
                modifier = Modifier.clickable(onClick = onClick)
            )
            if (uiState.isVotingOpen) {
                Row {
                    VoteButton(
                        text = "찬성",
                        onClick = {}
                    )
                    VoteButton(
                        text = "반대",
                        onClick = {}
                    )
                }
            } else {
                Column {
                    VoteResult(
                        ratio = uiState.ratio ?: 0.5f
                    )
                    Text(
                        text = "이 투표 공유"
                    )
                }
            }
        }
    }
    if (openDialog.value) {
        VoteDialog(
            onDismiss = {
                openDialog.value = false
            },
            onConfirm = onClickVote,
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun VoteScreenPreview() {
    VoteScreen(
        uiState = VoteUiState(),
        onClick = {},
        paddingValues = PaddingValues()
    )
}
