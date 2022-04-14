package br.com.ioasys.appcamp.data_remote.model

import com.google.gson.annotations.SerializedName

data class SingUpResponse(
    @SerializedName("name")
    val user: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
//    @SerializedName("cpf")
//    val cpf: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("role_id")
    val roleId: String
)