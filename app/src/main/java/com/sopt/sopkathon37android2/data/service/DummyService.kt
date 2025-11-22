package com.sopt.sopkathon37android2.data.service

import com.sopt.sopkathon37android2.data.dto.base.DummyBaseResponse
import com.sopt.sopkathon37android2.data.dto.request.DummyRequestDto
import com.sopt.sopkathon37android2.data.dto.response.DummyResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DummyService {
    @GET("/api/v1/service/{dummyPath}")
    suspend fun getDummies(
        @Path("dummyPath") dummyPath: Long,
    ): DummyBaseResponse<DummyResponseDto>

    @POST("/api/v1/service")
    suspend fun postDummies(
        @Body request: DummyRequestDto,
    ): DummyBaseResponse<DummyResponseDto>
}
