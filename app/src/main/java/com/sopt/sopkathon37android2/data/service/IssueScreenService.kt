package com.sopt.sopkathon37android2.data.service

import com.sopt.sopkathon37android2.data.dto.base.BaseResponse
import com.sopt.sopkathon37android2.data.dto.response.BestIssueResponseDto
import com.sopt.sopkathon37android2.data.dto.response.IssueResponseDto
import com.sopt.sopkathon37android2.data.dto.response.VotedIssueResponseDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface IssueScreenService {
    @GET("/api/v1/issues/best")
    suspend fun getBestIssue(): BaseResponse<BestIssueResponseDto>

    @GET("/api/v1/issues")
    suspend fun getIssues(
        @Header("userId") userId: Long,
        @Header("Content-Type") contentType: String = "application/json",
        @Query("range") range: String = "all",
        @Query("order") order: String = "recommend"
    ): BaseResponse<List<IssueResponseDto>>

    @GET("/api/v1/issues/pass")
    suspend fun getVotedIssues(): BaseResponse<List<VotedIssueResponseDto>>
}
