package br.com.ioasys.appcamp.data_local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Professionals")
data class ProfessionalDataLocal(

    @PrimaryKey
    val id: String,
    val crmCrp: String? = null,
    val name: String? = null,
    val cpf: String? = null,
    val email: String? = null,
    val password: String? = null,
    val gender: String? = null,
    val role: String? = null,
    val phone: String? = null,
    val cellphone: String? = null,
    val specialty: String? = null,
    val street: String? = null,
    val number: String? = null,
    val neighborhood: String? = null,
    val city: String? = null,
    val state: String? = null,
    val value: String? = null,
    val description: String? = null,
    val courses: String? = null,
    val healthPlan: String? = null,
    val bathroomSpecific: Boolean?=null,
    val linkedin: String? = null,
    val accessToken: String

)