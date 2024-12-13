package com.example.meleve.ui.screen

import com.example.meleve.data.model.Ride

sealed class TravelOptionsUiEvent {
    data class OnConfirmTravel(val ride: Ride): TravelOptionsUiEvent()
//    data class OnOriginEdit(val origin: String): TravelOptionsUiEvent()
//    data class OnDestinationEdit(val destination: String): TravelOptionsUiEvent()
//    data object ConsumeNavigationEvent : TravelOptionsUiEvent()
}