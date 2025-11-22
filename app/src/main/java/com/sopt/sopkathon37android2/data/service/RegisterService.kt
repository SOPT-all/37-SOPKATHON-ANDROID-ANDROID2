package com.sopt.sopkathon37android2.data.service

import com.sopt.sopkathon37android2.data.dto.request.RegisterRequestDto
import com.sopt.sopkathon37android2.data.dto.response.RegisterResponseDto
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface RegisterService {
    @POST("/api/v1/issues")
    suspend fun postRegister(
        @Header("userId") userId: Long,
        @Body request: RegisterRequestDto
    ): RegisterResponseDto
}