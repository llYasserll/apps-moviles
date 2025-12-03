package com.example.test.data.remote

import com.example.test.data.model.CafeItem
import com.example.test.data.model.LoginResponse
import com.example.test.data.model.RegisterResponse
import com.example.test.data.model.UserAuth
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("api/users/register")
    fun registerUser(@Body user: UserAuth): Call<RegisterResponse>
    @POST("api/users/login")
    fun login(@Body user: UserAuth): Call<LoginResponse>
    @GET("api/cafes")
    suspend fun getCafes(): List<CafeItem>

}