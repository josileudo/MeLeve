package com.example.meleve.ui.components.form

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meleve.ui.components.button.MeLeveButton

@Composable
fun MeLeveForm() {
    Column(modifier = Modifier.padding(12.dp)) {
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("User id") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("Origin") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("Destination") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MeLeveFormPreview() {
    MeLeveForm()
}