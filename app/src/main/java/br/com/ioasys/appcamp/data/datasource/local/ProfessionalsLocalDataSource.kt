package br.com.ioasys.appcamp.data.datasource.local

import br.com.ioasys.appcamp.domain.model.Professional
import kotlinx.coroutines.flow.Flow


interface ProfessionalsLocalDataSource {

    fun getAccessToken(): Flow<String>
    fun saveProfessionals(professionalList: List<Professional>)
    fun getProfessionals(accessToken: String): Flow<List<Professional>>

}