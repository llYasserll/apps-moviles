package com.example.test.ui.components

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.data.UserRepository
import com.example.test.data.model.RegisterResponse
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val repository = UserRepository()

    var isLoading = mutableStateOf(false)
    var registerResponse: RegisterResponse? = null
    var errorMessage: String? = null

    fun register(fullName: String, email: String, password: String) {
        isLoading.value = true
        errorMessage = null

        viewModelScope.launch {
            repository.registerUser(fullName, email, password) { response ->
                isLoading.value = false
                if (response != null) {
                    registerResponse = response
                } else {
                    errorMessage = "Error al registrar. Intente nuevamente."
                }
            }
        }
    }
}
