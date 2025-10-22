package com.example.test.data.remote

import com.example.test.data.model.LoginResponse
import com.example.test.data.model.RegisterResponse
import com.example.test.data.model.UserAuth
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call

interface ApiService {
    @POST("api/users/register")
    fun registerUser(@Body body: Map<String, String>): Call<RegisterResponse>

    @POST("api/users/login")
    fun login(@Body user: UserAuth): Call<LoginResponse>
}