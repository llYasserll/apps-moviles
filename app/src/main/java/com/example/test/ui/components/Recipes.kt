package com.example.test.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test.R

data class FoodItem(
    val name: String,
    val imageRes: Int
)

@Composable
fun FoodGridCard(
    modifier: Modifier = Modifier,
    title: String = "Your Recipes",
    items: List<FoodItem>
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFF6F91)), // 💗 mismo rosado
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.Start)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                val displayItems = when {
                    items.size >= 2 -> items.take(2)
                    items.isEmpty() -> emptyList()
                    else -> listOf(items[0])
                }

                for (it in displayItems) {
                    FoodItemCard(
                        modifier = Modifier.weight(1f),
                        item = it
                    )
                }
            }
        }
    }
}

@Composable
fun FoodItemCard(
    modifier: Modifier = Modifier,
    item: FoodItem,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            ) {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = item.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // ❤️ Botón favorito con fondo rosado
                IconButton(
                    onClick = { /* TODO: acción de favorito */ },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(6.dp)
                ) {
                    Surface(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape),
                        color = Color(0xFFFF6F91) // 💗 rosado igual que el diseño
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_heart),
                                contentDescription = "Favorito",
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }
            }

            // 🍰 Nombre del plato
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clickable(enabled = onClick != null) { onClick?.invoke() }
                    .background(Color.White)
            ) {
                Text(
                    text = item.name,
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun FoodGridCardPreview() {
    val samples = listOf(
        FoodItem(name = "Chicken Burger", imageRes = R.drawable.chicken),
        FoodItem(name = "Tiramisu", imageRes = R.drawable.tiramisu)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // 🔹 Fondo negro global
            .padding(16.dp)
    ) {
        FoodGridCard(title = "Your Recipes", items = samples)
    }
}
