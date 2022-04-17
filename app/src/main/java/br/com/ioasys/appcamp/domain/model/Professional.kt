package br.com.ioasys.appcamp.domain.model

data class Professional(
    val accessToken: String,
    val crmCrp: String,
    val id: String,
    val name: String,
    val cpf: String,
    val email: String,
    val password: String,
    val gender: String,
    val role: String,
    val phone: String,
    val cellphone: String,
    val specialty: String,
    val street: String,
    val number: String,
    val neighborhood: String,
    val city: String,
    val state: String,
    val value: String,
    val description: String,
    val courses: String,
    val healthPlan: String,
    val bathroomSpecific: Boolean,
    val linkedin: String,
//    val meet: String
)
