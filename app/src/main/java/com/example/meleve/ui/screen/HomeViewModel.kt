package com.example.meleve.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meleve.core.network.MeLeveRemoteDataSource
import com.example.meleve.data.model.MeLeveEstimatePayload
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private var _uiState = MutableStateFlow(HomeUiState())
    var uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onEvent(event: HomeUiEvent) {
        when(event) {
            is HomeUiEvent.OnFetchEstimates -> sendDestination(event.payload)
            is HomeUiEvent.OnCustomerEdit -> onCustomerEdit(event.id)
            is HomeUiEvent.OnOriginEdit -> onOriginEdit(event.origin)
            is HomeUiEvent.OnDestinationEdit -> onDestinationEdit(event.destination)
        }
    }

    fun onCustomerEdit(id: String) {
        _uiState.value = _uiState.value.copy(customerId = id )
    }

    fun onOriginEdit(origin: String) {
        _uiState.value = _uiState.value.copy(origin = origin )
    }

    fun onDestinationEdit(destination: String) {
        _uiState.value = _uiState.value.copy(destination = destination )
    }

    fun sendDestination(payload: MeLeveEstimatePayload) {
        viewModelScope.launch {
            _uiState.update { currentUiState ->
                MeLeveRemoteDataSource.sendDestination(payload).fold(
                    onSuccess = { estimate ->
                        currentUiState.copy(estimate = estimate)
                    },
                    onFailure = {_ ->
                        currentUiState.copy(estimate = null)
                    }
                )
            }
        }
    }
}