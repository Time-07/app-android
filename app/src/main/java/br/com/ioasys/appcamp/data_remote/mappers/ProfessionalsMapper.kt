package br.com.ioasys.appcamp.data_remote.mappers

import br.com.ioasys.appcamp.data_remote.model.ProfessionalResponse
import br.com.ioasys.appcamp.domain.model.Professional

fun List<ProfessionalResponse>.toDomain(): List<Professional> {
    return this.map {
        Professional(
            id = it.id ?: "",
            token = it.accessToken ?: "",
            crmCrp = it.crmCrp ?: "",
            name = it.name ?: "",
            cpf = it.cpf ?: "",
            email = it.email ?: "",
            password = it.password ?: "",
            gender = it.gender ?: "",
            role = it.role ?: "",
            phone = it.phone ?: "",
            cellphone = it.cellphone ?: "",
            specialty = it.specialty ?: "",
            street = it.street ?: "",
            neighborhood = it.neighborhood ?: "",
            number = it.number ?: "",
            city = it.city ?: "",
            state = it.state ?: "",
            value = it.value ?: "",
            description = it.description ?: "",
            courses = it.courses ?: "",
            healthPlan = it.healthPlan ?: "",
            linkedin = it.linkedin ?: "",
            bathroomSpecific = it.bathroomSpecific ?: ""
        )
    }
}