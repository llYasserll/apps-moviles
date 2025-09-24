package com.example.test.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

enum class BrandColors { Primary, Secondary1, Secondary11, Secondary2, Secondary3}
val BackgroundColorsMap: Map<BrandColors, Color> = mapOf(
    BrandColors.Primary to Color(0xFF00C1B8),
    BrandColors.Secondary1 to Color(0xFF279FAA),
    BrandColors.Secondary11 to Color(0xFF8BDAD6),
    BrandColors.Secondary2 to Color(0xFFF4F7FF),
    BrandColors.Secondary3 to Color(0xFF16464C)
)

enum class AccentColors { Primary, Secondary2, Secondary3}
val CheckColorsMap: Map<AccentColors, Color> = mapOf(
    AccentColors.Primary to Color(0xFF00C1B8),
    AccentColors.Secondary2 to Color(0xFF279FAA),
    AccentColors.Secondary3 to Color(0xFF8BDAD6)
)
enum class LabelColors { Primary, Secondary2, Secondary3, Secondary4}
val TextColorsMap: Map<LabelColors, Color> = mapOf(
    LabelColors.Primary to Color(0xFF00C1B8),
    LabelColors.Secondary2 to Color(0xFF279FAA),
    LabelColors.Secondary3 to Color(0xFF8BDAD6),
    LabelColors.Secondary4 to Color(0xFFF4F7FF)
)
enum class FillColors { Primary, Secondary2, Secondary3}
val InputFillColorsMap: Map<FillColors, Color> = mapOf(
    FillColors.Primary to Color(0xFF1F1F1F),
    FillColors.Secondary2 to Color(0xFF363636),
    FillColors.Secondary3 to Color(0xFF6E6E6E)
)