package br.com.ioasys.appcamp.data_remote.mappers

import br.com.ioasys.appcamp.data_remote.model.LoginResponse
import br.com.ioasys.appcamp.domain.model.User

fun LoginResponse.toDomain(accessToken: String) = User(
    name = this.name,
    birthdate = this.birthdate,
    gender = this.gender,
    accessToken = accessToken,
    id = this.id
)