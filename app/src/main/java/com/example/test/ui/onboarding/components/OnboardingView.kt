package com.example.test.ui.onboarding.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.test.ui.onboarding.model.OnboardingPage
import com.example.test.ui.theme.White
import com.example.test.ui.theme.RedPink

@Composable
fun OnboardingView(page: OnboardingPage, modifier: Modifier = Modifier) {

    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Imagen SVG del onboarding
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(
                    "android.resource://${context.packageName}/raw/${
                        context.resources.getResourceEntryName(page.imageRes)
                    }"
                )
                .decoderFactory(SvgDecoder.Factory())
                .build(),
            contentDescription = page.title,
            modifier = Modifier.size(220.dp)
        )

        Spacer(Modifier.height(24.dp))

        // Título del paso
        Text(
            text = page.title,
            color = RedPink,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.height(8.dp))

        // Descripción del paso
        Text(
            text = page.description,
            color = White,
            fontSize = 14.sp,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
    }
}
