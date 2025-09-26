package com.mmunoz.chirp.service.auth

import com.mmunoz.chirp.domain.exception.UserAlreadyExistException
import com.mmunoz.chirp.domain.model.User
import com.mmunoz.chirp.infra.database.entities.UserEntity
import com.mmunoz.chirp.infra.database.mappers.toUser
import com.mmunoz.chirp.infra.database.repositories.UserRepository
import com.mmunoz.chirp.infra.security.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun register(email: String, username: String, password: String): User {
        val user = userRepository.findByEmailOrUsername(
            email = email.trim(),
            username = username.trim()
        )

        if(user != null){
            throw UserAlreadyExistException()
        }

        val saveUser = userRepository.save(
            UserEntity(
                email = email.trim(),
                username = username.trim(),
                hashedPassword = passwordEncoder.encode(password)!!
            )
        ).toUser()
        return saveUser
    }
}