package com.example.test.data

import com.example.test.data.model.RegisterResponse
import com.example.test.data.model.UserAuth
import com.example.test.data.remote.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun registerUser(
        fullName: String,
        email: String,
        password: String,
        onResult: (RegisterResponse?) -> Unit
    ) {
        val userAuth = UserAuth(fullName = fullName, email = email, password = password)

        RetrofitInstance.api.registerUser(userAuth).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful) {
                    onResult(response.body())
                } else {
                    onResult(null)
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                onResult(null)
            }
        })
    }
}
