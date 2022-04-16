package br.com.ioasys.appcamp.domain.model

data class Professional(
    val id: Int,
    val name: String,
    val cpf: String,
    val email: String,
    val password: String,
    val gender: String,
    val role: String,
    val phone: Int,
    val cellphone: Int,
    val crmCrp: String,
    val specialty: String,
    val street: String,
    val number: Int,
    val neighborhood: String,
    val city: String,
    val state: String,
    val value: Int,
    val description: String,
    val courses: String,
    val healthPlan: String,
    val bathroomSpecific: Boolean,
    val linkedin: String,
    val imageUrl: String = ""
)
