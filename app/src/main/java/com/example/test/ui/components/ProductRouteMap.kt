package com.example.test.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.test.ui.theme.Black
import com.google.maps.android.compose.*
import com.google.android.gms.maps.model.*

@Composable
fun ProductRouteMap(
    routePoints: List<LatLng>,
    modifier: Modifier = Modifier,
    routeColor: Int = 0xFFFF0000.toInt()
) {
    if (routePoints.isEmpty()) return

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(routePoints.first(), 13f)
    }

    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {

        Polyline(
            points = routePoints,
            color = Black,
            width = 8f
        )


        Marker(
            state = MarkerState(position = routePoints.first()),
            title = "Inicio"
        )


        Marker(
            state = MarkerState(position = routePoints.last()),
            title = "Fin"
        )
    }
}