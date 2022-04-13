package br.com.ioasys.appcamp.domain.model

data class User(
    val email: String,
    val password: String,
    val accessToken: String,
    val gender: String,
    val id: String
    )
