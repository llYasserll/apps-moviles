package com.example.test.ui.onboarding

import com.example.test.R

data class OnboardingPage(
    val title: String,
    val description: String,
    val imageRes: Int
)

val onboarding1 = OnboardingPage(
    title = "Bienvenido a PillTrack",
    description = "Tu compañero confiable para que nunca olvides tus medicamentos.aaaaaaaaa",
    imageRes = R.raw.onboarding1
)

