package com.sopt.sopkathon37android2.data.service

import com.sopt.sopkathon37android2.data.dto.base.DummyBaseResponse
import com.sopt.sopkathon37android2.data.dto.request.VoteRequestDto
import com.sopt.sopkathon37android2.data.dto.response.VoteResponseDto
import com.sopt.sopkathon37android2.data.dto.response.VotedPageData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface VoteService {
    @GET("/api/v1/votes/{issue_id}")
    suspend fun getVote(
        @Path("issue_id") issueId: Long,
        @Header("userId") userId: Long,
        @Header("content-Type") contentType: String = "application/json",
    ): DummyBaseResponse<VotedPageData>

    @POST("/api/v1/votes/{issue_id}")
    suspend fun vote(
        @Header("userId") userId: Long,
        @Path("issue_id") issueId: Long,
        @Body request: VoteRequestDto
    ): DummyBaseResponse<VoteResponseDto>
}