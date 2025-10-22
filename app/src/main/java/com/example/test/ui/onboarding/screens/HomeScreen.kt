package com.example.test.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.test.R

data class CafeItem(
    val nombre: String,
    val precio: String,
    val imagen: Int
)

@Composable
fun HomeScreen(navController: NavHostController) {
    var selectedItem by remember { mutableStateOf("home") }
    var searchQuery by remember { mutableStateOf("") }

    val cafes = listOf(
        CafeItem("Café Espresso", "S/ 8.00", R.drawable.cafe_espresso),
        CafeItem("Café Americano", "S/ 9.00", R.drawable.cafe_americano),
        CafeItem("Café Latte", "S/ 10.00", R.drawable.cafe_latte),
        CafeItem("Café Capuccino", "S/ 11.00", R.drawable.cafe_capuccino)
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedItem = selectedItem,
                onItemSelected = { selectedItem = it; navController.navigate(it) }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F9F7))
                .padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Text(
                        text = "Hola, Eddy",
                        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                        color = Color(0xFF1A4D2E)
                    )
                    Text("Encuentra tu café favorito ☕", color = Color.Gray)

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        label = { Text("Buscar café o proveedor") },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                }

                items(cafes) { cafe ->
                    CafeCard(cafe)
                }
            }
        }
    }
}

@Composable
fun CafeCard(cafe: CafeItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = cafe.imagen),
                contentDescription = cafe.nombre,
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = cafe.nombre,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A4D2E)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = cafe.precio,
                    color = Color(0xFF4B7355),
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { /*  acción comprar o ver detalle */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A4D2E)),
                    modifier = Modifier.height(36.dp)
                ) {
                    Text("Ordenar", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(selectedItem: String, onItemSelected: (String) -> Unit) {
    NavigationBar(containerColor = Color(0xFF1A4D2E)) {
        NavigationBarItem(
            selected = selectedItem == "home",
            onClick = { onItemSelected("home") },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Inicio", tint = Color.White) },
            alwaysShowLabel = false,
            label = { Text("Inicio") }
        )
        NavigationBarItem(
            selected = selectedItem == "products",
            onClick = { onItemSelected("products") },
            icon = { Icon(Icons.Filled.LocalCafe, contentDescription = "Productos", tint = Color.White) },
            alwaysShowLabel = false,
            label = { Text("Café") }
        )
        NavigationBarItem(
            selected = selectedItem == "orders",
            onClick = { onItemSelected("orders") },
            icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "Pedidos", tint = Color.White) },
            alwaysShowLabel = false,
            label = { Text("Pedidos") }
        )
        NavigationBarItem(
            selected = selectedItem == "profile",
            onClick = { onItemSelected("profile") },
            icon = { Icon(Icons.Filled.Person, contentDescription = "Perfil", tint = Color.White) },
            alwaysShowLabel = false,
            label = { Text("Perfil") }
        )
    }
}

