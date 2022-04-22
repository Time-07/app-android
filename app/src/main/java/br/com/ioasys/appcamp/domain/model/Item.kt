package br.com.ioasys.appcamp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val id: Int,
    val crmCrp: String,
    val name: String,
    val cpf: String,
    val email: String,
    val gender: String,
    val role: String,
    val phone: String,
    val cellphone: String,
    val specialty: String,
    val street: String,
    val number: String,
    val cityAndState: String,
    val address: String,
    val state: String,
    val value: String,
    val healthPlan: String,
    val bathroomSpecific: String,
    val meet: String,
    val treatmentPronoun: String,
    val professionalFirstName: String,
    val professionalLastName: String,
    val experience: String,
    val curriculum: String
) : Parcelable {
    companion object {

        fun getMockList() = listOf(
            Item(
                id = 1,
                crmCrp = "CRM/SP 123456",
                name = "Dr.Silva\nMaranhão",
                cpf = "001.001.001-01",
                email = "silva@gmail.com",
                gender = "Mulher Cis",
                role = "Profissional",
                phone = "(71) 0111-2222",
                cellphone = "(71) 0222-1111",
                specialty = "Urologia",
                street = "Av. Roberto Carlos",
                number = "190",
                cityAndState = "SP - São Paulo ",
                state = "Online e\n Presencial",
                value = "R$159,99",
                healthPlan = "Atende convênio",
                bathroomSpecific = "Banheiro Inclusivo",
                meet = "Online e Presencial",
                address = "Avenida Brasil, 644, Centro, Sala 266",
                treatmentPronoun = "Dra",
                professionalFirstName = "Silva",
                professionalLastName = "Maranhão",
                experience = "",
                curriculum = ""
            ),
            Item(
                id = 2,
                crmCrp = "CRM/SP 123456",
                name = "Dr.Silva\nMaranhão",
                cpf = "001.001.001-01",
                email = "silva@gmail.com",
                gender = "Mulher Cis",
                role = "Profissional",
                phone = "(71) 0111-2222",
                cellphone = "(71) 0222-1111",
                specialty = "Urologia",
                street = "Av. Roberto Carlos",
                number = "190",
                cityAndState = "SP - São Paulo ",
                state = "Online e\n Presencial",
                value = "R$159,99",
                healthPlan = "Atende convênio",
                bathroomSpecific = "Banheiro Inclusivo",
                meet = "Online e Presencial",
                address = "Avenida Brasil, 644, Centro, Sala 266",
                treatmentPronoun = "Dra",
                professionalFirstName = "Silva",
                professionalLastName = "Maranhão",
                experience = "Desde a faculdade sempre estive muito atenta a questão da saúde mental LGBT+, tenho e já tive pacientes trans de diferentes vivências e origens. No meu consultório você terá a garantia de encontrar um ambiente acolhedor e propício para conversarmos sobre a sua saúde sem julgamentos",
                curriculum = " Formada em medicina pela Universidade Estadual do Piauí - UESPI, residência psiquiátrica no Instituto de Medicina Integral Professor Fernando Figueira (IMIP), especialização em Transtorno Depressivo e Bipolaridade pelo instituto de psicologia aplicada da Universidade de São Paulo.\n"
            )
        )
    }
}
