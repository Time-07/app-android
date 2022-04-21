package br.com.ioasys.appcamp.domain.model

data class Items(
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
    val neighborhood: String,
    val cityAndState: String,
    val city: String,
    val address: String,
    val state: String,
    val value: String,
    val description: String,
    val courses: String,
    val healthPlan: String,
    val bathroomSpecific: String,
    val linkedin: String,
    val meet: String
) {
    companion object {

        fun getMockList() = listOf(
            Items(
                id = 1,
                crmCrp = "CRM/SP 123456",
                name = "Dr.Lucas",
                cpf = "001.001.001-01",
                email = "luscas@gmail.com",
                gender = "Homem Cis",
                role = "Profissional",
                phone = "(71) 0111-2222",
                cellphone = "(71) 0222-1111",
                specialty = "Urologia",
                street = "Av. Roberto Carlos",
                number = "190",
                neighborhood = "Bairro do Juazeiro",
                cityAndState = "SP - São Paulo ",
                city = "São Paulo",
                state = "Online e\n Presencial",
                value = "R$159,99",
                description = "",
                courses = "",
                healthPlan = "Atende convênio",
                bathroomSpecific = "Banheiro Inclusivo",
                linkedin = "",
                meet = "Online e Presencial",
                address = "Avenida Brasil, 644, Centro, Sala 266"
            )
        )
    }
}
