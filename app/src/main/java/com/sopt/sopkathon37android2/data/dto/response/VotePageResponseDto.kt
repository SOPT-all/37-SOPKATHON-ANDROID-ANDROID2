package com.sopt.sopkathon37android2.data.dto.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class VotedPageResponse(
    @SerialName("data")
    val data: VotedPageData,
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val status: Int
)

@Serializable
data class VotedPageData(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("imageUrl")
    val imageUrl: List<String>,
    @SerialName("college")
    val college: String,
    @SerialName("department")
    val department: String,
    @SerialName("agreeCount")
    val agreeCount: Int? = null,
    @SerialName("disagreeCount")
    val disagreeCount: Int? = null,
    @SerialName("isVoted")
    val isVoted: Boolean,
    @SerialName("isAgree")
    val isAgreed: Boolean? = null,
)

