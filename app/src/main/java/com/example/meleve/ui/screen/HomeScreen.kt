package com.example.meleve.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.meleve.ui.components.form.MeLeveForm

@Composable
fun HomeScreen(
    onNavigationToTravelOptions: () -> Unit = {}
) {
    Column {
        TravelSolicitation(onNavigationToTravelOptions = onNavigationToTravelOptions)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}