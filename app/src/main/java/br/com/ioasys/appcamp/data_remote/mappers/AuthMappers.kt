package br.com.ioasys.appcamp.data_remote.mappers

import br.com.ioasys.appcamp.data_remote.model.LoginResponse
import br.com.ioasys.appcamp.domain.model.User

fun LoginResponse.toDomain() = User(
    role = role,
    accessToken = accessToken
)