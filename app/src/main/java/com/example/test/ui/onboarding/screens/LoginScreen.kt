package com.example.test.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Lock
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.test.R
import com.example.test.ui.components.PrimaryButton


@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // 🎨 Fondo general
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F9F7)), // verde muy claro
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            // 🔹 LOGO ARRIBA
            Image(
                painter = painterResource(id = R.drawable.ic_launcher), //
                contentDescription = "Logo de la app",
                modifier = Modifier
                    .size(120.dp)
                    .padding(bottom = 24.dp)
            )

            // 🔹 Texto de bienvenida
            Text(
                text = "Bienvenido",
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFF1A4D2E) // verde oscuro
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 🔹 Campo de correo
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo electrónico") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Icono de usuario"
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            var passwordVisible by remember { mutableStateOf(false) }

            // 🔹 Campo de contraseña
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Icono de candado"
                    )
                },
                trailingIcon = {
                    val image = if (passwordVisible)
                        androidx.compose.material.icons.Icons.Filled.Visibility
                    else
                        androidx.compose.material.icons.Icons.Filled.VisibilityOff

                    androidx.compose.material3.IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        androidx.compose.material3.Icon(
                            imageVector = image,
                            contentDescription = if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña"
                        )
                    }
                },
                visualTransformation = if (passwordVisible)
                    androidx.compose.ui.text.input.VisualTransformation.None
                else
                    PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(16.dp))


            TextButton(
                onClick = { navController.navigate("forgot_password")
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    text = "¿Olvidaste tu contraseña?",
                    color = Color(0xFF1A4D2E), // verde oscuro, para mantener el estilo
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            // 🔹 Botón de ingresar
            PrimaryButton(
                onClick = { navController.navigate("home") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                text = "Ingresar"
            )


            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "¿No tienes cuenta? ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
                TextButton(
                    onClick = { navController.navigate("register")
                    }
                ) {
                    Text(
                        text = "Regístrate",
                        color = Color(0xFF1A4D2E), // verde oscuro o tu color temático
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
