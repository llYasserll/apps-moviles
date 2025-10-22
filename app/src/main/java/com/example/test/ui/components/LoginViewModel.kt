package com.example.test.ui.components


import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.test.data.model.*
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

    fun loginUser() {
        isLoading.value = true
        errorMessage.value = null
        successMessage.value = null

        val userAuth = UserAuth(email.value, password.value)

        RetrofitInstance.api.login(userAuth).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                isLoading.value = false
                if (response.isSuccessful) {
                    successMessage.value = "Inicio de sesión exitoso"
                    Log.d("LOGIN_SUCCESS", "Token: ${response.body()?.accessToken}")
                } else {
                    errorMessage.value = "Credenciales incorrectas o error del servidor"
                    Log.e("LOGIN_ERROR", "Código: ${response.code()}")
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
