package com.example.meleve.data.model

import kotlinx.serialization.Serializable

data class LatLng (
    val latitude: Double,
    val longitude: Double
)

data class MeLeveOptions (
    val id: Int,
    val name: String,
    val description: String,
    val vehicle: String,
    val review: MeLeveReview,
    val value: Double
)

data class MeLeveReview (
    var rating: Int,
    var comment: String
)

data class MeLeveDestination(
    var origin: LatLng,
    var destination: LatLng,
    var distance: Double,
    var duration: String,
    var options: MeLeveOptions,
    var routeResponse: Any?
)

