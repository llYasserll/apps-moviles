package com.example.test.ui.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import androidx.compose.ui.platform.LocalContext

@Composable
fun OnboardingPageView(page: OnboardingPage) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data("android.resource://${context.packageName}/raw/${context.resources.getResourceEntryName(page.imageRes)}")
                .decoderFactory(SvgDecoder.Factory())
                .build(),
            contentDescription = page.title,
            modifier = Modifier.size(220.dp)
        )
    }
}
