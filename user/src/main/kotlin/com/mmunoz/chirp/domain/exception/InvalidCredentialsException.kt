package com.mmunoz.chirp.domain.exception

class InvalidCredentialsException: RuntimeException(
    "The entered credentials aren't valid"
) {
}