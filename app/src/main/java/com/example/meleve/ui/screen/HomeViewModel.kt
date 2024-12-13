package com.example.meleve.ui.screen

import MeLeveEstimate
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meleve.core.network.MeLeveRemoteDataSource
import com.example.meleve.data.model.MeLeveEstimatePayload
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(HomeUiState())
    var uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onEvent(event: HomeUiEvent) {
        when (event) {
            is HomeUiEvent.OnFetchEstimates -> sendDestination()
            is HomeUiEvent.OnCustomerEdit -> onCustomerEdit(event.id)
            is HomeUiEvent.OnOriginEdit -> onOriginEdit(event.origin)
            is HomeUiEvent.OnDestinationEdit -> onDestinationEdit(event.destination)
            is HomeUiEvent.ConsumeNavigationEvent -> consumeNavigationEvent()
        }
    }

    fun consumeNavigationEvent() {
        _uiState.update { it.copy(navigationEvent = null) }
    }

    private fun onCustomerEdit(id: String) {
        _uiState.value = _uiState.value.copy(customerId = id)
    }

    private fun onOriginEdit(origin: String) {
        _uiState.value = _uiState.value.copy(origin = origin)
    }

    private fun onDestinationEdit(destination: String) {
        _uiState.value = _uiState.value.copy(destination = destination)
    }

    private fun sendDestination() {
        val payload = MeLeveEstimatePayload(
            customer_id = _uiState.value.customerId,
            origin = _uiState.value.origin,
            destination = _uiState.value.destination
        )
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            MeLeveRemoteDataSource.sendDestination(payload).fold(
                onSuccess = { estimate ->
                    _uiState.update { currentUiState ->
                        currentUiState.copy(
                            estimate = estimate,
                            isLoading = false,
                            navigationEvent = NavigationEvent.ToTravelOptions
                        )
                    }
                },
                onFailure = { err ->
                    _uiState.update { currentUiState ->
                        currentUiState.copy(
                            estimate = null,
                            isLoading = false,
                            error = err.message
                        )
                    }
                }
            )
        }
    }
}