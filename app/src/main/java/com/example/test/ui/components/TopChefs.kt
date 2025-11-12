package com.example.tuapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.R

@Composable
fun MainCard(
    title: String,
    leftImageRes: Int,
    leftLabel: String,
    rightImageRes: Int,
    rightLabel: String
) {
    val borderColor = Color(0xFF6200EE)     // Morado
    val backgroundColor = Color(0xFFF5F5F5) // Gris claro

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(
                width = 2.dp,                 // Grosor del borde
                color = borderColor,          // 👈 Color del borde
                shape = RoundedCornerShape(12.dp)
            ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor // 👈 Color de fondo
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Título
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Fila con las dos cards internas
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SubCard(
                    imageRes = leftImageRes,
                    label = leftLabel,
                    modifier = Modifier.weight(1f)
                )

                SubCard(
                    imageRes = rightImageRes,
                    label = rightLabel,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun SubCard(
    imageRes: Int,
    label: String,
    modifier: Modifier = Modifier
) {
    // 🎨 Colores personalizados para las subcards
    val borderColor = Color(0xFF03A9F4)     // Azul
    val backgroundColor = Color(0xFFE3F2FD) // Azul claro

    Column(
        modifier = modifier
            .border(
                width = 1.dp,
                color = borderColor,          // 👈 color del borde
                shape = RoundedCornerShape(10.dp)
            )
            .padding(8.dp)
            .background(backgroundColor, shape = RoundedCornerShape(10.dp)), // 👈 color del fondo
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = label,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium
            )
        )
    }
}


@Composable
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
fun MainCardPreview() {
    MaterialTheme {
        MainCard(
            title = "Opciones disponibles",
            leftImageRes = R.drawable.ic_launcher_foreground, // ejemplo
            leftLabel = "Perfil",
            rightImageRes = R.drawable.ic_launcher_foreground,
            rightLabel = "Ajustes"
        )
    }
}

