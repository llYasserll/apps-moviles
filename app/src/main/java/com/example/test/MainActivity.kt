package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.test.navigation.NavGraph
import com.example.test.ui.components.ProductRouteMap
import com.example.test.ui.theme.TestTheme
import com.google.android.gms.maps.model.LatLng

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*val route = listOf(
                //Lima
                LatLng(-12.0464, -77.0428),
                LatLng(-12.0564, -77.0500),
                LatLng(-12.0600, -77.0700),
                LatLng(-12.0620, -77.0800)
            )

            ProductRouteMap(
                routePoints = route,
                modifier = Modifier.fillMaxSize()
            )*/
            TestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = androidx.compose.material3.MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavGraph(navController = navController)
                }
            }
        }
    }
}
