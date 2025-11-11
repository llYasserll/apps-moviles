package com.example.test.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

// 🎨 Esquema de colores basado en tu archivo Color.kt
private val DarkColorScheme = darkColorScheme(
    primary = Pink,           // Botones y elementos principales
    secondary = SweetPink,    // Elementos secundarios
    tertiary = RedPink,       // Acentos (acciones importantes)
    background = Black,       // Fondo principal negro
    surface = BrownPod,       // Fondo secundario (tarjetas, formularios)
    onPrimary = Black,        // Texto sobre botones claros
    onSecondary = White,      // Texto sobre elementos secundarios
    onTertiary = White,       // Texto sobre acentos
    onBackground = White,     // Texto sobre fondo principal
    onSurface = White         // Texto sobre superficies secundarias
)

private val LightColorScheme = lightColorScheme(
    primary = SweetPink,
    secondary = Pink,
    tertiary = RedPink,
    background = White,
    surface = Pink80,
    onPrimary = Black,
    onSecondary = Black,
    onTertiary = Black,
    onBackground = Black,
    onSurface = Black
)

@Composable
fun TestTheme(
    darkTheme: Boolean = true, // ⚫ Forzamos modo oscuro (puedes cambiar a isSystemInDarkTheme())
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
