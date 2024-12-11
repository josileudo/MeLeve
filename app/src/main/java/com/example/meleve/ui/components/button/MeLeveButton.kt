package com.example.meleve.ui.components.button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MeLeveButton(
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier.heightIn(min = 56.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = {}
    ) {
        Box() {
            Text("Ver preços")
        }
    }
}

@Preview
@Composable
fun MeLeveForm() {
    MeLeveButton()
}