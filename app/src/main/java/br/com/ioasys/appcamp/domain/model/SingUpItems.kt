package br.com.ioasys.appcamp.domain.model

data class SingUpItems(
    val userSingUp: String,
    val emailSingUp: String,
    val passwordSingUp: String,
    val confirmPassword: String,
    val gender: String,
    val cpf: String
)
