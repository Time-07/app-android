package br.com.ioasys.appcamp.data_remote.model

import com.google.gson.annotations.SerializedName

data class ProfessionalResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("crmCrp")
    val crmCrp: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("cpf")
    val cpf: String? = "",
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("gender")
    val gender: String? = "",
    @SerializedName("role")
    val role: String? = "",
    @SerializedName("phone")
    val phone: String? = "",
    @SerializedName("cellPhone")
    val cellphone: String? = "",
    @SerializedName("speciality")
    val specialty: String? = "",
    @SerializedName("street")
    val street: String? = "",
    @SerializedName("number")
    val number: String? = "",
    @SerializedName("neighborhood")
    val neighborhood: String? = "",
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("state")
    val state: String? = "",
    @SerializedName("value")
    val value: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("course")
    val courses: String? = "",
    @SerializedName("healthPlan")
    val healthPlan: String? = "",
    @SerializedName("bathroomSpecific")
    val bathroomSpecific: String? = "",
    @SerializedName("linkedin")
    val linkedin: String? = "",
)