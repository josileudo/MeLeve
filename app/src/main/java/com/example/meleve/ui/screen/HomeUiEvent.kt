package com.example.meleve.ui.screen

sealed class HomeUiEvent {
    data object OnFetchEstimates: HomeUiEvent()
    data class OnCustomerEdit(val id: String): HomeUiEvent()
    data class OnOriginEdit(val origin: String): HomeUiEvent()
    data class OnDestinationEdit(val destination: String): HomeUiEvent()
    data object ConsumeNavigationEvent : HomeUiEvent()
}

