package com.example.meleve.ui.screen

import com.example.meleve.data.model.MeLeveEstimatePayload

sealed class HomeUiEvent {
    data class OnFetchEstimates(val payload: MeLeveEstimatePayload): HomeUiEvent()
    data class OnCustomerEdit(val id: String): HomeUiEvent()
    data class OnOriginEdit(val origin: String): HomeUiEvent()
    data class OnDestinationEdit(val destination: String): HomeUiEvent()
}

