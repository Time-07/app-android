package br.com.ioasys.appcamp.data.datasource.remote

import br.com.ioasys.appcamp.domain.model.Professional
import kotlinx.coroutines.flow.Flow

interface ProfessionalsRemoteDataSource {

    fun getProfessionals(accessToken: String, query: String?) : Flow<List<Professional>>
}