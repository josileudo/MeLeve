package com.example.meleve.ui.components.map

import RouteResponse
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.meleve.ui.theme.GreenBase
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptorFactory

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.JointType
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

import com.google.maps.android.PolyUtil
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberMarkerState
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun MeLeveMap(modifier: Modifier, routeResponse: RouteResponse) {
    val context = LocalContext.current
    val singapore = LatLng(1.35, 103.87)
    val singaporeb = LatLng(1.3493456934475694, 103.86694272515606)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }
    val polyline = routeResponse.routes.first().polyline.encodedPolyline
    val routePoints = remember { PolyUtil.decode(polyline) }
    val markerOrigin = rememberMarkerState(position = singapore)
    val markerDestination = rememberMarkerState(position = singaporeb)

    LaunchedEffect(routePoints) {
        if (routePoints.isNotEmpty()) {
            val boundsBuilder = LatLngBounds.builder()
            routePoints.forEach {boundsBuilder.include(it)}
            val bounds = boundsBuilder.build()
            cameraPositionState.move(CameraUpdateFactory.newLatLngBounds(bounds, 100))
        }
    }

    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState,
    ) {
        Polyline(
            points = routePoints,
            color = Color.Red,
            width = 10f,
            jointType = JointType.ROUND
        )

        val startLocation = routeResponse.routes.first().legs.first().startLocation.latLng
        val endLocation = routeResponse.routes.first().legs.first().endLocation.latLng

        markerOrigin.position = LatLng(startLocation.latitude, startLocation.longitude)
        markerDestination.position = LatLng(endLocation.latitude, endLocation.longitude)

        Marker(
            state = markerOrigin,
            title = "Origem",
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
        )

        Marker(
            state = markerDestination,
            title = "Destino",
        )

    }
}

