package com.example.meleve.ui.screen

import MeLeveEstimate

data class HomeUiState(
    val estimate: MeLeveEstimate? = null,

    var customerId: String = "CT01",
    var origin: String = "Av. Brasil, 2033 - Jardim America, São Paulo - SP, 01431-001",
    var destination: String = "Av. Paulista, 1538 - Bela Vista, São Paulo - SP, 01310-200",

    val isLoading: Boolean = false,
    val error: String? = null,

    val navigationEvent: NavigationEvent? = null
)

sealed class NavigationEvent {
    data object ToTravelOptions: NavigationEvent()
}
