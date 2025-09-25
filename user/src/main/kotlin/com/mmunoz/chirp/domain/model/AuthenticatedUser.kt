package com.mmunoz.chirp.domain.model

data class AuthenticatedUser(
    val user: User,
    val accessToken: String,
    val refreshToken: String
)
