package com.example.test.ui.components

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import com.example.test.data.model.RegisterResponse
import com.example.test.data.remote.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class RegisterViewModel : ViewModel() {

    var isLoading by mutableStateOf(false)
    var registerResponse by mutableStateOf<RegisterResponse?>(null)
    var errorMessage by mutableStateOf<String?>(null)

    fun register(fullName: String, email: String, password: String) {
        println(" email=$email")

        isLoading = true
        errorMessage = null

        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.registerUser(
                    mapOf(
                        "fullName" to fullName,
                        "email" to email,
                        "password" to password
                    )
                ).execute()

                println("Respuesta HTTP: ${response.code()}")

                if (response.isSuccessful) {
                    registerResponse = response.body()
                    println("Registro exitoso: ${response.body()}")
                } else {
                    val errorBody = response.errorBody()?.string()
                    println("Error HTTP ${response.code()}: $errorBody")
                    errorMessage = "Error ${response.code()}: $errorBody"
                }
            } catch (e: IOException) {
                println("Error de red: ${e.message}")
                errorMessage = "Error de red: ${e.message}"
            } catch (e: HttpException) {
                println("Error HTTP: ${e.message}")
                errorMessage = "Error HTTP: ${e.message}"
            } catch (e: Exception) {
                println("Error inesperado: ${e.message}")
                errorMessage = "Error desconocido: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }
}
