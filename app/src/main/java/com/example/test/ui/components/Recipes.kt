package com.example.test.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
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
    title: String = "Recomendados",
    items: List<FoodItem>
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
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
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
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
                    modifier = Modifier.fillMaxSize()
                )

                // Ícono con fondo circular sólido
                IconButton(
                    onClick = { /* TODO: acción de favorito */ },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(6.dp)
                ) {
                    Surface(
                        modifier = Modifier
                            .size(32.dp) // 🔹 Cambia este valor para ajustar el tamaño del círculo
                            .clip(CircleShape),
                        color = MaterialTheme.colorScheme.primary // 🔹 Color sólido del fondo
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_heart),
                                contentDescription = "Favorito",
                                modifier = Modifier.size(18.dp) // 🔹 Cambia este valor para ajustar el tamaño del ícono
                            )
                        }
                    }
                }
            }

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp),
                shadowElevation = 2.dp
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable(enabled = onClick != null) { onClick?.invoke() }
                ) {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodGridCardPreview() {
    val samples = listOf(
        FoodItem(name = "Tacos al Pastor", imageRes = R.drawable.ic_launcher_foreground),
        FoodItem(name = "Sushi Roll", imageRes = R.drawable.ic_launcher_foreground)
    )

    FoodGridCard(title = "Favoritos de hoy", items = samples)
}
