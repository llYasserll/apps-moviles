package com.example.test.ui.onboarding.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.test.ui.onboarding.model.OnboardingPage

@Composable
fun OnboardingPageView(page: OnboardingPage, modifier: Modifier) {

    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(
                    "android.resource://${context.packageName}/raw/${
                        context.resources.getResourceEntryName(
                            page.imageRes
                        )
                    }"
                )
                .decoderFactory(SvgDecoder.Factory())
                .build(),
            contentDescription = page.title,
            modifier = Modifier.size(220.dp)
        )

        Spacer(Modifier.height(24.dp))

        Text(
            text = page.title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = page.description,
            fontSize = 14.sp
        )
    }
}
