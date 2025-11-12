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
            fullName = "", // no se usa en login
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

                    // 🚀 Ejecuta la función callback (navegar a Home)
                    onSuccess()
                } else {
                    errorMessage.value = "Credenciales incorrectas o error del servidor"
                    Log.e("LOGIN_ERROR", "Código: ${response.code()} - ${response.message()}")
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    isLoading.value = false
                    errorMessage.value = "Error de red: ${t.localizedMessage}"
                    Log.e("LOGIN_ERROR", "Error en login", t)
                }
            })
        }
    }
