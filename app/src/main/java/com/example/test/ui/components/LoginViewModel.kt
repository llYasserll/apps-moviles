package com.example.test.ui.components

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.test.data.model.LoginResponse
import com.example.test.data.model.UserAuth
import com.example.test.data.remote.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var errorMessage = mutableStateOf<String?>(null)
    var successMessage = mutableStateOf<String?>(null)

    fun loginUser(onSuccess: () -> Unit) {
        isLoading.value = true
        errorMessage.value = null
        successMessage.value = null

        val userAuth = UserAuth(
            fullName = "",
            email = email.value,
            password = password.value
        )

        RetrofitInstance.api.login(userAuth).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                isLoading.value = false

                if (response.isSuccessful && response.body()?.accessToken != null) {
                    val loginResponse = response.body()
                    successMessage.value = "Inicio de sesión exitoso ✅"
                    Log.d("LOGIN_SUCCESS", "Token: ${loginResponse?.accessToken}")
                    onSuccess()
                } else {
                    val rawError = try {
                        response.errorBody()?.string()
                    } catch (e: Exception) {
                        "No se pudo leer el cuerpo de error (${e.localizedMessage})"
                    }

                    Log.e("LOGIN_DEBUG", "Código: ${response.code()}")
                    Log.e("LOGIN_DEBUG", "Mensaje del servidor: $rawError")
                    Log.e("LOGIN_DEBUG", "Mensaje HTTP: ${response.message()}")

                    // Analiza el mensaje
                    val parsedMessage = when {
                        rawError?.contains("Invalid", ignoreCase = true) == true -> "Credenciales incorrectas"
                        rawError?.contains("message") == true -> {
                            Regex("\"message\"\\s*:\\s*\"([^\"]+)\"").find(rawError)?.groupValues?.get(1)
                                ?: "Error al iniciar sesión"
                        }
                        else -> "Error al iniciar sesión"
                    }

                    errorMessage.value = parsedMessage
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                isLoading.value = false
                errorMessage.value = "Error de red: ${t.localizedMessage}"
                Log.e("LOGIN_ERROR", "Error en login", t)
            }
        })
    }

}
