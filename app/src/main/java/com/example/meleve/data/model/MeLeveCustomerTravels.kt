
package com.example.meleve.data.model
import kotlinx.serialization.Serializable

@Serializable
data class MeLeveCustomerTravels(
    val customer_id: String,
    val rides: List<Ride>
)

@Serializable
data class Ride(
    val id: Int,
    val date: String,
    val origin: String,
    val destination: String,
    val distance: Double,
    val duration: String,
    val driver: Driver,
    val value: Double
)

@Serializable
data class Driver(
    val id: Int,
    val name: String
)