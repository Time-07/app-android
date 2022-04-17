package br.com.ioasys.appcamp.data.data_local.mappers

import br.com.ioasys.appcamp.data_local.model.ProfessionalDataLocal
import br.com.ioasys.appcamp.domain.model.Professional

// TODO: Depois vou checar o motivo dos warnings
fun Professional.toDao() : ProfessionalDataLocal {
    return ProfessionalDataLocal(
        accessToken = this.accessToken,
        crmCrp = this.crmCrp,
        id = this.id.toInt(),
        name = this.name,
        cpf = this.cpf,
        email = this.email,
        password = this.password,
        gender = this.gender,
        role = this.role,
        phone = this.phone.toInt(),
        cellphone = this.cellphone.toInt(),
        specialty = this.specialty,
        street = this.street,
        number = this.number.toInt(),
        neighborhood = this.neighborhood,
        city = this.city,
        state = this.state,
        value = this.value.toInt(),
        description = this.description,
        courses = this.courses,
        healthPlan = this.healthPlan,
        bathroomSpecific = this.bathroomSpecific,
        linkedin = this.linkedin
    )
}

fun ProfessionalDataLocal.toDomain(): Professional{
    return Professional(
        accessToken = this.accessToken,
        crmCrp = this.crmCrp ?: "",
        id = this.id.toString(),
        name = this.name ?: "",
        cpf = this.cpf ?: "",
        email = this.email ?: "",
        password = this.password ?: "",
        gender = this.gender ?: "",
        role = this.role ?: "",
        phone = this.phone.toString(),
        cellphone = this.cellphone.toString(),
        specialty = this.specialty ?: "",
        street = this.street ?: "",
        number = this.number.toString(),
        neighborhood = this.neighborhood ?: "",
        city = this.city ?: "",
        state = this.state ?: "",
        value = this.value.toString(),
        description = this.description ?: "",
        courses = this.courses ?: "",
        healthPlan = this.healthPlan ?: "",
        bathroomSpecific = this.bathroomSpecific,
        linkedin = this.linkedin ?: ""
    )

}