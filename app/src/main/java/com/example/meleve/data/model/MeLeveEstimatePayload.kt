package com.example.meleve.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MeLeveEstimatePayload(
    val customer_id: String,
    val origin: String,
    val destination: String,
)
