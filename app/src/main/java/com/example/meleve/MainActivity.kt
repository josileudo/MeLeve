package com.example.meleve

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meleve.ui.theme.MeLeveTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.StrokeStyle
import com.google.android.gms.maps.model.StyleSpan
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.rememberCameraPositionState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MeLeveTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
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

                    Column {

//                        FormDestination()

//                        GoogleMap(
//                            modifier = Modifier,
//                            cameraPositionState = cameraPositionState,
//                        ) {
//
//                        }
                    }
                }
            }
        }
    }
}
