package com.sopt.sopkathon37android2.presentation.vote

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.sopt.sopkathon37android2.core.designsystem.ui.theme.SopkathonTheme
import com.sopt.sopkathon37android2.presentation.vote.component.VoteAgreeButton
import com.sopt.sopkathon37android2.presentation.vote.component.VoteDialog
import com.sopt.sopkathon37android2.presentation.vote.component.VoteDisagreeButton
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
        voteAgree = viewModel::voteAgree,
        voteDisagree = viewModel::voteDisagree,
        paddingValues = paddingValues,
    )
}

@Composable
private fun VoteScreen(
    uiState: VoteUiState,
    paddingValues: PaddingValues,
    onClick: () -> Unit,
    voteAgree: () -> Unit,
    voteDisagree: () -> Unit,
    modifier: Modifier = Modifier,
    onClickVote: () -> Unit = {},
) {
    val openDialog = remember {
        mutableStateOf(false)
    }

    Column(
        modifier =
            modifier
                .background(
                    color = SopkathonTheme.colors.gray01
                )
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
    ) {
        //탑 바 추가
        Column(
            modifier = Modifier
                .padding(horizontal = 14.dp, vertical = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = uiState.title,
                    color = SopkathonTheme.colors.black,
                    style = SopkathonTheme.typography.title.sb_16
                )
                Spacer(modifier = Modifier.width(8.dp))
                VoteStage(
                    text = uiState.stage,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = uiState.writer,
                    color = SopkathonTheme.colors.gray04,
                    style = SopkathonTheme.typography.body.m_14
                )
            }
            Spacer(modifier = Modifier.height(height = 16.dp))
            LazyColumn(
                modifier = Modifier
                    .background(
                        color = SopkathonTheme.colors.white,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(all = 16.dp)
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                item {
                    Text(
                        text = uiState.content,
                        color = SopkathonTheme.colors.gray05,
                        style = SopkathonTheme.typography.body.m_14,
                    )
                }
            }
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            ) {
                items(
                    items = uiState.imgList ?: emptyList()
                ) { imgUrl ->
                    AsyncImage(
                        model = imgUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(104.dp)
                            .clip(RoundedCornerShape(4.dp))
                    )
                }

            }
            if (uiState.isVoted) {
                Spacer(modifier = Modifier.height(86.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    VoteAgreeButton(
                        onClick = {voteAgree()}
                    )
                    VoteDisagreeButton(
                        onClick = {voteDisagree()}
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
            } else {
                Spacer(modifier = Modifier.height(30.dp))
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    VoteResult(
                        maxVoter = uiState.maxVoter,
                        currentVoter = if (uiState.isAgreed) uiState.agreeVoter else uiState.disagreeVoter,
                        isAgreed = uiState.isAgreed
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        VoteAgreeButton(
                            isEnabled = uiState.isAgreed
                        )
                        VoteDisagreeButton(
                            isEnabled = uiState.isAgreed.not()
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
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
/*
@Composable
@Preview(showBackground = true)
private fun VoteScreenPreview() {
    VoteScreen(
        uiState = VoteUiState(

        ),
        onClick = {},
        paddingValues = PaddingValues()
    )
}
*/