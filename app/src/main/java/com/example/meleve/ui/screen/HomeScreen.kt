package com.example.meleve.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meleve.ui.components.button.MeLeveButton
import com.example.meleve.ui.screen.Route.Home

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUiState,
    onEvent: (HomeUiEvent) -> Unit,
    onNavigationToTravelOptions: () -> Unit = {},
) {

    LaunchedEffect(uiState.navigationEvent) {
        when (uiState.navigationEvent) {
            is NavigationEvent.ToTravelOptions -> {
                onNavigationToTravelOptions()
                onEvent(HomeUiEvent.ConsumeNavigationEvent)
            }
            null -> Unit
        }
    }


    Column {
        Column(modifier = Modifier.padding(12.dp)) {
            OutlinedTextField(
                value = uiState.customerId,
                onValueChange = { onEvent.invoke(HomeUiEvent.OnCustomerEdit(it)) },
                label = { Text("User id") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = uiState.origin,
                onValueChange = { onEvent.invoke(HomeUiEvent.OnOriginEdit(it)) },
                label = { Text("Origin") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = uiState.destination,
                onValueChange = {onEvent.invoke(HomeUiEvent.OnDestinationEdit(it))},
                label = { Text("Destination") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        MeLeveButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            iconRes = Icons.Filled.LocationOn,
            text = "ver preços",
            isLoading = uiState.isLoading,
            onClick = {
                onEvent.invoke(HomeUiEvent.OnFetchEstimates)
            }
        )

        Text(text = "${uiState.isLoading}")

        Text(text = "${uiState.estimate}, ${uiState.origin}, ${uiState.destination}")
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TravelSolicitationPreview() {
    HomeScreen(modifier = Modifier, uiState = HomeUiState(), onEvent = { })
}