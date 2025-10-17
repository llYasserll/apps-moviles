package com.example.test.ui.onboarding.model

import com.example.test.R

data class OnboardingPage(
    val title: String,
    val description: String,
    val imageRes: Int
)

val onboarding1 = OnboardingPage(
    title = "Onboarding1",
    description = "la desripcion del onboarding 1",
    imageRes = R.raw.onboarding1
)

val onboarding2 = OnboardingPage(
    title = "Onboarding2",
    description = "Descripcion del onboarding2",
    imageRes = R.raw.onboarding1
)

