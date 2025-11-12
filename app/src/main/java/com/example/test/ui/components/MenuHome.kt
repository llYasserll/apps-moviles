package com.example.test.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.test.R

data class MenuItem(
    val title: String,
    val icon: Int
)

@Composable
fun BottomMenuBar(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit
) {
    val items = listOf(
        MenuItem("Inicio", R.drawable.ic_home),
        MenuItem("Chats", R.drawable.ic_chat),
        MenuItem("Pestañas", R.drawable.ic_tabs),
        MenuItem("Usuario", R.drawable.ic_user)
    )

    // Contenedor general del menú (anclado abajo)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,
            tonalElevation = 6.dp,
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp)) // 🔹 Bordes redondeados
                .fillMaxWidth(0.95f),            // 🔹 Un poco de margen lateral
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = selectedItem == index

                val iconSize by animateFloatAsState(
                    targetValue = if (isSelected) 28f else 24f,
                    label = "iconSizeAnim"
                )

                NavigationBarItem(
                    selected = isSelected,
                    onClick = { onItemSelected(index) },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title,
                            modifier = Modifier.size(iconSize.dp),
                            tint = if (isSelected)
                                MaterialTheme.colorScheme.primary
                            else
                                Color.Gray
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = if (isSelected)
                                MaterialTheme.colorScheme.primary
                            else
                                Color.Gray
                        )
                    },
                    alwaysShowLabel = true,
                    // 🔹 Reduce espacio entre íconos
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
        }
    }
}

//ola
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewBottomMenuBar() {
    MaterialTheme {
        var selectedItem by remember { mutableStateOf(0) }
        BottomMenuBar(
            selectedItem = selectedItem,
            onItemSelected = { selectedItem = it }
        )
    }
}
