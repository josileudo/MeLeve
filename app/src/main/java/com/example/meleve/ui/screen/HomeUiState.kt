package com.example.meleve.ui.screen

import MeLeveEstimate

data class HomeUiState(
    val estimate: MeLeveEstimate? = null,

    var customerId: String = "CT01",
    var origin: String = "",
    var destination: String = "",

    val isLoading: Boolean = false,
    val error: String? = null,

    val navigationEvent: NavigationEvent? = null,
)

sealed class NavigationEvent {
    data object ToTravelOptions: NavigationEvent()
    data object OpenAlert: NavigationEvent()
}
