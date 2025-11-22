package com.sopt.sopkathon37android2.data.service

import com.sopt.sopkathon37android2.data.dto.response.RecommendResponseDto
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface RecommendService {

    @POST("/api/v1/recommends/{issue_id}")
    suspend fun postRecommend(
        @Header("userId") userId: Long,
        @Path("issue_id") issueId: Long
    ): RecommendResponseDto
}