package br.com.ioasys.appcamp.domain.respositories

import br.com.ioasys.appcamp.domain.model.Professional
import kotlinx.coroutines.flow.Flow

interface ProfessionalsRepository {

    fun getAllProfessionals(
        accessToken: String
    ): Flow<List<Professional>>

    fun getProfessionals(
        gender: String,
        name: String,
        specialty: String,
        city: String
    ): Flow<List<Professional>>

    fun saveProfessionals(professionalList: List<Professional>)

}