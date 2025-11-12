package com.example.test.ui.onboarding.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.test.ui.theme.TestTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.example.test.ui.components.PrimaryButton
import com.example.test.ui.onboarding.components.OnboardingView
import com.example.test.ui.onboarding.model.onboarding1
import com.example.test.ui.onboarding.model.onboarding2
import com.example.test.ui.theme.RedPink

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun OnboardingScreen(onNext: () -> Unit) {

    // Páginas del onboarding
    val pages = listOf(onboarding1, onboarding2)
    var currentPage by remember { mutableStateOf(0) }
    var direction by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Spacer(Modifier.height(16.dp))

        AnimatedContent(
            targetState = currentPage,
            transitionSpec = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth * direction },
                    animationSpec = tween(400)
                ) togetherWith slideOutHorizontally(
                    targetOffsetX = { fullWidth -> -fullWidth * direction },
                    animationSpec = tween(400)
                )
            }, label = "pageTransition"
        ) { page ->
            OnboardingView(
                page = pages[page],
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
        PrimaryButton(
            text = "Next",
            onClick = {if (currentPage < pages.lastIndex) {
                direction = 1
                currentPage++
            } else {
                onNext()
            }},
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewOnboardingScreen() {
    TestTheme {
        OnboardingScreen(onNext = {})
    }
}
