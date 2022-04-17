package br.com.ioasys.appcamp.domain.model

data class Items(
    val accessToken: String,
    val crmCrp: String,
    val id: Int,
    val name: String,
    val cpf: String,
    val email: String,
    val password: String,
    val gender: String,
    val role: String,
    val phone: Int,
    val cellphone: Int,
    val specialty: String,
    val street: String,
    val number: Int,
    val neighborhood: String,
    val cityAndState: String,
    val city: String,
    val state: String,
    val value: String,
    val description: String,
    val courses: String,
    val healthPlan: String,
    val bathroomSpecific: Boolean,
    val linkedin: String,
    val meet: String
)
