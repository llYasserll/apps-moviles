package com.example.test.data.model

data class UserAuth(
    val email: String,
    val password: String
)

data class UserProfile(
    val id: String,
    val email: String,
    val fullName: String
)

data class RegisterResponse(
    val profile: UserProfile,
    val accessToken: String,
    val refreshToken: String
)

data class LoginResponse(
    val profile: UserProfile,
    val accessToken: String?,
    val refreshToken: String?
)