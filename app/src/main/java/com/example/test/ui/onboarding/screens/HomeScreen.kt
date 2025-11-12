package com.example.test.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.test.R
import com.example.test.ui.components.BottomMenuBar
import com.example.test.ui.theme.*

data class CafeItem(
    val nombre: String,
    val precio: String,
    val imagen: Int
)

@Composable
fun HomeScreen(navController: NavHostController) {
    var selectedItem by remember { mutableStateOf(0) }
    var searchQuery by remember { mutableStateOf("") }

    val cafes = listOf(
        CafeItem("Café en Grano Tunki Tipo Americano 215g", "S/ 8.00", R.drawable.im_cafeamericano),
        CafeItem("Café Gourmet Zokya 250gr", "S/ 9.00", R.drawable.im_cafegourmet),
        CafeItem("Café Latte", "S/ 10.00", R.drawable.cafe_latte),
        CafeItem("Café Capuccino", "S/ 11.00", R.drawable.cafe_capuccino)
    )

    Scaffold(
        bottomBar = {
            BottomMenuBar(
                selectedItem = selectedItem,
                onItemSelected = { index ->
                    selectedItem = index
                    when (index) {
                        0 -> navController.navigate("home")
                        1 -> navController.navigate("chats")
                        2 -> navController.navigate("tabs")
                        3 -> navController.navigate("profile")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(White) // 🎨 Color del tema
                .padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Text(
                        text = "Hola, Eddy 👋",
                        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                        color = BrownPod
                    )
                    Text("Encuentra tu café favorito ☕", color = SweetPink)

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        label = { Text("Buscar café o proveedor") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Buscar",
                                tint = BrownPod
                            )
                        },
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
        colors = CardDefaults.cardColors(containerColor = Pink),
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
                    color = BrownPod
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = cafe.precio,
                    color = RedPink,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { /* acción comprar o ver detalle */ },
                    colors = ButtonDefaults.buttonColors(containerColor = SweetPink),
                    modifier = Modifier.height(36.dp)
                ) {
                    Text("Ordenar", color = White)
                }
            }
        }
    }
}


