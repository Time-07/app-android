package br.com.ioasys.appcamp.data.data_local.mappers

import br.com.ioasys.appcamp.data_local.model.ProfessionalDataLocal
import br.com.ioasys.appcamp.domain.model.Professional

// TODO: Depois vou checar o motivo dos warnings
fun Professional.toDao() : ProfessionalDataLocal = ProfessionalDataLocal(
        id = this.id,
        crmCrp = this.crmCrp,
        name = this.name,
        cpf = this.cpf,
        email = this.email,
        password = this.password,
        gender = this.gender,
        role = this.role,
        phone = this.phone,
        cellphone = this.cellphone,
        specialty = this.specialty,
        street = this.street,
        number = this.number,
        neighborhood = this.neighborhood,
        city = this.city,
        state = this.state,
        value = this.value,
        description = this.description,
        courses = this.courses,
        healthPlan = this.healthPlan,
        bathroomSpecific = this.bathroomSpecific,
        linkedin = this.linkedin
)

fun ProfessionalDataLocal.toDomain(): Professional = Professional(
        id = this.id,
        crmCrp = this.crmCrp?:"",
        name = this.name?:"",
        cpf = this.cpf?:"",
        email = this.email?:"",
        password = this.password?:"",
        gender = this.gender?:"",
        role = this.role?:"",
        phone = this.phone?:"",
        cellphone = this.cellphone?:"",
        specialty = this.specialty?:"",
        street = this.street?:"",
        number = this.number?:"",
        neighborhood = this.neighborhood?:"",
        city = this.city?:"",
        state = this.state?:"",
        value = this.value?:"",
        description = this.description?:"",
        courses = this.courses?:"",
        healthPlan = this.healthPlan?:"",
        bathroomSpecific = this.bathroomSpecific?:false,
        linkedin = this.linkedin?:""
)