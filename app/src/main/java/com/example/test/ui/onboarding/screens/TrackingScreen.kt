package com.example.test.ui.onboarding.screens

import androidx.compose.runtime.Composable
import com.example.test.R
import com.example.test.ui.components.ProductRouteMap
import com.example.test.ui.screens.CafeItem
import com.google.android.gms.maps.model.LatLng



@Composable
fun TrackingScreen(cafeName: String) {

    val cafes = listOf(
        CafeItem("Café Espresso", "S/ 8.00", R.drawable.cafe_espresso, -15.838836890992736, -70.02814384810597),
        CafeItem("Café Americano", "S/ 9.00", R.drawable.cafe_americano, -12.005303051009932, -77.09893414659031),
        CafeItem("Café Latte", "S/ 10.00", R.drawable.cafe_latte, -13.517684809887477, -71.97473092698121),
        CafeItem("Café Capuccino", "S/ 11.00", R.drawable.cafe_capuccino, -12.076499720223184, -77.03668521687571)
    )

    val cafe = cafes.find { it.nombre == cafeName } ?: cafes.first()

    val userLocation = LatLng(-12.04318, -77.02824)
    val cafeLocation = LatLng(cafe.lat, cafe.lng)
    val route = listOf(userLocation, cafeLocation)

    ProductRouteMap(routePoints = route)
}
