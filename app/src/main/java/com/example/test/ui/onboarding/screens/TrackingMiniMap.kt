package com.example.test.ui.onboarding.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.test.ui.screens.CafeItem
import com.example.test.ui.components.ProductRouteMap
import com.google.android.gms.maps.model.LatLng

@Composable
fun TrackingMiniMap(cafe: CafeItem) {

    val userLocation = LatLng(-12.04318, -77.02824)
    val cafeLocation = LatLng(cafe.lat, cafe.lng)
    val route = listOf(userLocation, cafeLocation)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp)
            .padding(16.dp)
    ) {

        Text(
            text = "Ruta hacia ${cafe.nombre}",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            ProductRouteMap(routePoints = route)
        }
    }
}