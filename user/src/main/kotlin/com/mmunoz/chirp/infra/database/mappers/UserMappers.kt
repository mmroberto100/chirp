package com.mmunoz.chirp.infra.database.mappers

import com.mmunoz.chirp.domain.model.User
import com.mmunoz.chirp.infra.database.entities.UserEntity

fun UserEntity.toUser(): User {
    return User(
        id = id!!,
        username = username,
        email = email,
        hasEmailVerified = hasVerifiedEmail
    )
}