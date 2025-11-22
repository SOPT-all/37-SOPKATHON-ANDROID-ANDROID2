package com.sopt.sopkathon37android2.data.service

import com.sopt.sopkathon37android2.data.dto.response.VoteBaseResponseDto
import com.sopt.sopkathon37android2.data.dto.response.VoteResponseDto
import retrofit2.http.GET
import retrofit2.http.Header

interface VoteService {
    @GET("/api/v1/issues/pass")
    suspend fun getVoteListsService(
        @Header("userId") userId: Long = 1
    ): VoteBaseResponseDto<List<VoteResponseDto>>
}
