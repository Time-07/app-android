package br.com.ioasys.appcamp.data.datasource.remote

import br.com.ioasys.appcamp.domain.model.Professional
import kotlinx.coroutines.flow.Flow

interface ProfessionalsRemoteDataSource {
    //passar os parâmetros que necessários para a requisição
    fun getProfessionals() : Flow<List<Professional>>
}