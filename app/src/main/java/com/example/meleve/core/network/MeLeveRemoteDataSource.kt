package com.example.meleve.core.network

import MeLeveEstimate
import com.example.meleve.core.network.KtorHttpClient.KtorHttpClient.httpClientAndroid
import com.example.meleve.data.model.MeLeveCustomerTravels
import com.example.meleve.data.model.MeLeveCustomerTravelsPayload
import com.example.meleve.data.model.MeLeveEstimatePayload
import com.example.meleve.data.model.MeLeveSuccessResponse
import com.example.meleve.data.model.Ride
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.parameters
import kotlinx.serialization.Serializable

@Serializable
data class MeLeveRequest (
    val request: MeLeveEstimatePayload
)

object MeLeveRemoteDataSource {
    private const val LOCAL_HOST_EMULATOR_BASE_URL = "http://10.0.2.2:3333"
    private const val BASE_URL = LOCAL_HOST_EMULATOR_BASE_URL

    suspend fun getCustomerTravels(payload: MeLeveCustomerTravelsPayload): Result<List<MeLeveCustomerTravels>> = try {
        val travels: List<MeLeveCustomerTravels> = httpClientAndroid.get {
            url("${BASE_URL}/ride/${payload.customerId}")
            parameter("driverId", payload.driverId)
        }.body<List<MeLeveCustomerTravels>>()

        Result.success(travels)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun sendDestination(payload: MeLeveEstimatePayload): Result<MeLeveEstimate> = try {
        val estimate: MeLeveEstimate = httpClientAndroid.post("${BASE_URL}/ride/estimate") {
            contentType(ContentType.Application.Json)
            setBody(payload)
        }.body()

        Result.success(estimate)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun confirmTravel(payload: Ride): Result<MeLeveSuccessResponse> = try {
        val confirm: MeLeveSuccessResponse = httpClientAndroid.post("${BASE_URL}/ride/confirm") {
            contentType(ContentType.Application.Json)
            setBody(payload)
        }.body()
        Result.success(confirm)
    } catch (e: Exception) {
        Result.failure(e)
    }
}