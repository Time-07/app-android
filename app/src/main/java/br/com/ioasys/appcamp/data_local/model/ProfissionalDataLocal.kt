package br.com.ioasys.appcamp.data_local.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Profissionals")
data class ProfissionalDataLocal(
    @PrimaryKey @NonNull
    val name: String? = null,
    val email: String? = null,
    val password: String? = null,
    val cpf: String? = null,
    val gender: String? = null,
    val cellPhone: Int? = null,
    val street: String? = null,
    val number: Int? = null,
    val neighborhood: String? = null,
    val city: String? = null,
    val state: String? = null,
    val crmCrp: String? = null,
    val specialty: String? = null,
    val phone: Int? = null,
    val value: Int? = null,
    val description: String? = null,
    val courses: String? = null,
    val healthPlan: String? = null,
    val bathroomSpecific: Boolean? = null,
    val linkedin: String? = null
)
