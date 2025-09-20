package com.example.test.ui.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.decode.SvgDecoder
import androidx.compose.ui.platform.LocalContext
import com.example.test.R


@Composable
fun OnboardingScreen(onFinish: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("android.resource://${LocalContext.current.packageName}/${R.raw.onboarding1}")
                .decoderFactory(SvgDecoder.Factory())
                .build(),
            contentDescription = "Onboarding Illustration",
            modifier = Modifier.fillMaxWidth().height(300.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text("Bienvenido a la app de prueba")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onFinish) {
            Text("Continuar")
        }
    }
}
