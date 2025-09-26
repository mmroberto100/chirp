package com.mmunoz.chirp.domain.exception

import java.lang.RuntimeException

class UserAlreadyExistException: RuntimeException(
    "A user with this username or email already exists."
)