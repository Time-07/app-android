package br.com.ioasys.appcamp.data.data_local.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Professionals")
data class ProfessionalDataLocal(
    @PrimaryKey @NonNull
    val accessToken: String,
    val crmCrp: String,
    val id: Int,
    val name: String? = null,
    val cpf: String? = null,
    val email: String? = null,
    val password: String? = null,
    val gender: String? = null,
    val role: String? = null,
    val phone: Int? = null,
    val cellphone: Int,
    val specialty: String? = null,
    val street: String? = null,
    val number: Int? = null,
    val neighborhood: String? = null,
    val city: String? = null,
    val state: String? = null,
    val value: Int? = null,
    val description: String? = null,
    val courses: String? = null,
    val healthPlan: String? = null,
    val bathroomSpecific: Boolean,
    val linkedin: String? = null,
    val imageUrl: String? = null
)
