package com.example.meleve.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MeLeveSuccessResponse(
    val success: Boolean,
)

@Serializable
data class MeLeveFailedResponse(
    val errorCode: String,
    val errorDescription: String
)
