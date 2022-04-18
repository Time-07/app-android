package br.com.ioasys.appcamp.data_remote.model

import com.google.gson.annotations.SerializedName

data class GetProfessionalsRequest(
    @SerializedName("id")
    val id: String,
    @SerializedName("crmCrp")
    val crmCrp: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("cpf")
    val cpf: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("role")
    val role: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("cellPhone")
    val cellphone: String? = null,
    @SerializedName("speciality")
    val specialty: String? = null,
    @SerializedName("street")
    val street: String? = null,
    @SerializedName("number")
    val number: String? = null,
    @SerializedName("neighborhood")
    val neighborhood: String? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("state")
    val state: String? = null,
    @SerializedName("value")
    val value: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("course")
    val courses: String? = null,
    @SerializedName("healthPlan")
    val healthPlan: String? = null,
    @SerializedName("bathroomSpecific")
    val bathroomSpecific: Boolean?=null,
    @SerializedName("linkedin")
    val linkedin: String? = null,
)