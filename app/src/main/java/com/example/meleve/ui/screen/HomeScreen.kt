package com.example.meleve.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meleve.ui.components.button.MeLeveButton
import com.example.meleve.ui.components.modal.MeLeveAlertModal
import com.example.meleve.ui.screen.Route.Home
import com.example.meleve.ui.theme.Typography

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUiState,
    onEvent: (HomeUiEvent) -> Unit,
    onNavigationToTravelOptions: () -> Unit = {},
) {
    val openAlertDialog = remember { mutableStateOf(false) }

    LaunchedEffect(uiState.navigationEvent) {
        when (uiState.navigationEvent) {
            is NavigationEvent.ToTravelOptions -> {
                onNavigationToTravelOptions()
                onEvent(HomeUiEvent.ConsumeNavigationEvent)
            }
            is NavigationEvent.OpenAlert -> {
                openAlertDialog.value = true
                onEvent(HomeUiEvent.ConsumeNavigationEvent)
            }
            null -> Unit
        }
    }

    if(openAlertDialog.value) {
        MeLeveAlertModal(
            icon = Icons.Filled.Warning,
            dialogText = uiState.error,
            showConfirmationButton = false,
            onDismissRequest = { openAlertDialog.value = false }
        )
    }

    Column(modifier = Modifier.padding(top = 20.dp)) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 22.dp),
            text = "Para onde queres ir?",
            style = Typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )

        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlinedTextField(
                value = uiState.customerId,
                onValueChange = { onEvent.invoke(HomeUiEvent.OnCustomerEdit(it)) },
                label = { Text("Id") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = uiState.origin,
                onValueChange = { onEvent.invoke(HomeUiEvent.OnOriginEdit(it)) },
                label = { Text("Origem") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = uiState.destination,
                onValueChange = {onEvent.invoke(HomeUiEvent.OnDestinationEdit(it))},
                label = { Text("Destino") },
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
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TravelSolicitationPreview() {
    HomeScreen(modifier = Modifier, uiState = HomeUiState(), onEvent = { })
}