package com.example.test.ui.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(onFinish: () -> Unit) {
    val pagerState = rememberPagerState()

    val pages = listOf(
        OnboardingPage(
            "Bienvenido a PillTrack",
            "Tu compañero confiable para que nunca olvides tus medicamentos.",
            imageRes = com.example.test.R.drawable.onboarding1
        ),
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            count = pages.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            OnboardingPageView(pages[page])
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(onClick = { onFinish() }) {
                Text("Saltar")
            }
            Button(onClick = {
                if (pagerState.currentPage < pages.size - 1) {
                    CoroutineScope(Dispatchers.Main).launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                } else {
                    onFinish()
                }
            }) {
                Text(if (pagerState.currentPage == pages.lastIndex) "Finalizar" else "Siguiente")
            }
        }
    }
}
