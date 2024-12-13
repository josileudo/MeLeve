package com.example.meleve.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meleve.core.network.MeLeveRemoteDataSource
import com.example.meleve.data.model.MeLeveEstimatePayload
import com.example.meleve.data.model.Ride
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TravelOptionsViewModel: ViewModel() {
    private var _uiState = MutableStateFlow(TravelOptionsUiState())
    var uiState: StateFlow<TravelOptionsUiState> = _uiState.asStateFlow()

    fun onEvent(event: TravelOptionsUiEvent) {
        when (event) {
            is TravelOptionsUiEvent.OnConfirmTravel -> sendConfirmTravel(event.ride)
        }
    }

    private fun sendConfirmTravel(ride: Ride) {
        viewModelScope.launch {
            MeLeveRemoteDataSource.confirmTravel(ride).fold(
                onSuccess = { ride ->
                    _uiState.update { currentState ->
                        currentState
                    }
                },
                onFailure = { err ->
//                    _uiState.update { currentUiState ->
//                        currentUiState.copy(
//                            isLoading = false,
//                            error = err.message,
//                            navigationEvent = NavigationEvent.OpenAlert
//                        )
//                    }
                }
            )
        }
    }

}