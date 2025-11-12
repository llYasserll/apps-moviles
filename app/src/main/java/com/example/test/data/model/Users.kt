package com.example.test.data.model

// --- Request ---
data class UserAuth(
    val fullName: String?,
    val email: String,
    val password: String
)

// --- Response ---
data class RegisterResponse(
    val message: String?,
    val data: RegisterData?
)

data class RegisterData(
    val profile: UserProfile?,
    val accessToken: String?,
    val refreshToken: String?
)

data class LoginResponse(
    val message: String?,
    val data: LoginData?
)

data class LoginData(
    val profile: UserProfile?,
    val accessToken: String?,
    val refreshToken: String?
)

// --- Common ---
data class UserProfile(
    val id: String?,
    val email: String?,
    val fullName: String?
)