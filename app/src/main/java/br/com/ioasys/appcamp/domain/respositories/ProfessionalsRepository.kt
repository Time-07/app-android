package br.com.ioasys.appcamp.domain.respositories

import br.com.ioasys.appcamp.domain.model.Professional
import kotlinx.coroutines.flow.Flow

interface ProfessionalsRepository {

    fun getProfessionals(): Flow<List<Professional>>
    fun saveProfessionals(professionalList: List<Professional>)

    fun getSearchProfessionalsRepository(query: String): Flow<List<Professional>>
}