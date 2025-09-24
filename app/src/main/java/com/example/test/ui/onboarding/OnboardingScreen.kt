package com.example.test.ui.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.decode.SvgDecoder
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.test.R
import com.example.test.ui.theme.TestTheme


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

        Text(
            text = "Bienvenido",
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        )

        Button(onClick = onFinish) {
            Text("Continuar al siguiente slideaaaa")
        }
    }
}

//Puedes correr solo este file para entrar a lo que estes diseñando sin compilar toda la app
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewOnboardingScreen() {
    TestTheme {
        OnboardingScreen(onFinish = {})
    }
}
