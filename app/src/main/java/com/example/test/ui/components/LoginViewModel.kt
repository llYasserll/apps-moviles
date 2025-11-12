package com.example.test.ui.components

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.test.data.model.LoginResponse
import com.example.test.data.model.UserAuth
import com.example.test.data.remote.RetrofitInstance
import okhttp3.ResponseBody
import org.json.JSONObject
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

                Log.d("LOGIN_DEBUG", "Código HTTP: ${response.code()}")
                Log.d("LOGIN_DEBUG", "Cuerpo exitoso: ${response.body()}")
                Log.d("LOGIN_DEBUG", "Cuerpo error: ${response.errorBody()?.string()}")

                val body = response.body()

                if (response.isSuccessful && body?.data?.accessToken != null) {
                    val token = body.data.accessToken
                    val profile = body.data.profile

                    successMessage.value = body.message ?: "Inicio de sesión exitoso "
                    Log.d("LOGIN_SUCCESS", "Token: $token")
                    Log.d("LOGIN_SUCCESS", "Usuario: ${profile?.fullName} (${profile?.email})")

                    onSuccess()
                } else {
                    val rawError = extractErrorBody(response.errorBody())
                    errorMessage.value = rawError
                    Log.e("LOGIN_ERROR", "Mensaje mostrado al usuario: $rawError")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                isLoading.value = false
                errorMessage.value = "Error de red: ${t.localizedMessage}"
                Log.e("LOGIN_FAILURE", "Fallo de red: ${t.localizedMessage}", t)
            }
        })
    }

    private fun extractErrorBody(errorBody: ResponseBody?): String {
        if (errorBody == null) return "Error desconocido (sin cuerpo de respuesta)"

        val errorString = try {
            errorBody.string()
        } catch (e: Exception) {
            return "Error al leer cuerpo de error"
        }

        return try {
            val json = JSONObject(errorString)
            json.optString("message", "Error sin mensaje en JSON: $errorString")
        } catch (e: Exception) {
            "Error no JSON: $errorString"
        }
    }
}