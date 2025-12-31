package com.example.pizzaapps.response.account

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val `data`: Data
)
