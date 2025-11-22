package com.sopt.sopkathon37android2.presentation.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sopkathon37android2.R
import com.sopt.sopkathon37android2.presentation.home.component.HomeBanner
import com.sopt.sopkathon37android2.presentation.home.component.HomeVote
import com.sopt.sopkathon37android2.presentation.home.model.VoteUiModel

@Composable
fun VoteScreen(
    voteList: List<VoteUiModel>,
    onVoteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(bottom = 84.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(12.dp))

            HomeBanner(
                bannerImage = R.drawable.img_vote_banner
            )

            Spacer(modifier = Modifier.height(7.dp))
        }

        items(
            items = voteList,
            key = { it.id }
        ) { vote ->
            Spacer(modifier = Modifier.height(12.dp))

            HomeVote(
                detailGroupTag = vote.detailGroupTag,
                tagType = vote.tagType,
                studentCouncil = vote.studentCouncil,
                voteTotalNumber = vote.voteTotalNumber,
                detailTitle = vote.detailTitle,
                detailGroup = vote.detailGroup,
                onVoteClick = onVoteClick
            )
        }
    }
}
