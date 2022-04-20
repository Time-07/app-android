package br.com.ioasys.appcamp.data.datasource.remote

import br.com.ioasys.appcamp.domain.model.Professional
import kotlinx.coroutines.flow.Flow

interface ProfessionalsRemoteDataSource {
    //passar os parâmetros que necessários para a requisição
    fun getProfessionalsListFiltered(
        accessToken: String,
        gender: String?,
        specialty: String?,
        city: String?
    ) : Flow<List<Professional>>

    fun getAllProfessionalsList(
        accessToken: String
    ) : Flow<List<Professional>>
}