package br.com.ioasys.appcamp.data_remote.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: String
)
