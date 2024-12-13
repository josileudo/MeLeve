package com.example.meleve.ui.screen

import com.example.meleve.data.model.MeLeveSuccessResponse

class TravelOptionsUiState {
    val successResponse: MeLeveSuccessResponse? = null
    val isLoading: Boolean = false
    val error: String? = null
    val tvlNavigation: TvlOptionNavigationEvent? = null
}

sealed class TvlOptionNavigationEvent {
    data object ConsumeNavigationEvent: TvlOptionNavigationEvent()
    data object OpenAlert: TvlOptionNavigationEvent()
}