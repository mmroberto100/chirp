package com.mmunoz.chirp.api.mappers

import com.mmunoz.chirp.api.dto.AuthenticatedUserDto
import com.mmunoz.chirp.api.dto.UserDto
import com.mmunoz.chirp.domain.model.AuthenticatedUser
import com.mmunoz.chirp.domain.model.User

fun AuthenticatedUser.toAuthenticatedUserDto(): AuthenticatedUserDto {
    return AuthenticatedUserDto(
        user = user.toUserDto(),
        accessToken = accessToken,
        refreshToken = refreshToken
    )
}

fun User.toUserDto(): UserDto {
    return UserDto(
        id = id,
        email = email,
        username = username,
        hasVerifiedEmail = hasEmailVerifier
    )
}