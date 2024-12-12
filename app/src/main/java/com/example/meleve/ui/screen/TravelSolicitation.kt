package com.example.meleve.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meleve.ui.components.button.MeLeveButton
import com.example.meleve.ui.components.form.MeLeveForm

@Composable
fun TravelSolicitation(
    modifier: Modifier = Modifier,
    onNavigationToTravelOptions: () -> Unit = {}
) {
    Column {
        MeLeveForm()

        Spacer(modifier = Modifier.height(16.dp))

        MeLeveButton(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            iconRes = Icons.Filled.LocationOn,
            text = "ver preços",
            onClick = onNavigationToTravelOptions
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TravelSolicitationPreview() {
    TravelSolicitation()
}