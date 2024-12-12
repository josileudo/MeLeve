package com.example.meleve.ui.components.map

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.StrokeStyle
import com.google.android.gms.maps.model.StyleSpan
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.example.meleve.R
import com.google.android.gms.maps.model.LatLng

@Composable
fun MeLeveMap(modifier: Modifier) {
    val context = LocalContext.current
    val singapore = LatLng(1.35, 103.87)
    val singaporeb = LatLng(1.3493456934475694, 103.86694272515606)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }

    val mapProperties = MapProperties(
        mapStyleOptions = MapStyleOptions.loadRawResourceStyle(context, R.raw.map_style),
        maxZoomPreference = 12f,
        minZoomPreference = 10f
    )

    val styleSpan = StyleSpan(
        StrokeStyle.gradientBuilder(
            Color.Red.toArgb(),
            Color.Green.toArgb(),
        ).build(),
    )
    val styleSpanList = remember { listOf(styleSpan) }

    val polylinePoints = listOf(singapore, singaporeb)

    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState,
    ) {}
}

