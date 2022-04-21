package br.com.ioasys.appcamp.data_remote.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("userRole")
    val role: String,
    @SerializedName("accessToken")
    val accessToken: String
)
