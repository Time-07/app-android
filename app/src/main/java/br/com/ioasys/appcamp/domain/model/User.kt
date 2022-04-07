package br.com.ioasys.appcamp.domain.model

data class User(
    val user: String,
    val email: String,
    val password: String,
    val gender: String,
    val accessToken: String,
    )
