package com.example.meleve.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MeLeveCustomerTravelsPayload(
    val customerId: Int,
    val driverId: Int
)
