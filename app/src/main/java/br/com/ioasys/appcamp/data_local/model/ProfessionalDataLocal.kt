package br.com.ioasys.appcamp.data_local.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Professionals")
data class ProfessionalDataLocal(

    @PrimaryKey @NonNull
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