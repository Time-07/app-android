package br.com.ioasys.appcamp.data_remote.datasource

import br.com.ioasys.appcamp.data.datasource.remote.ProfessionalsRemoteDataSource
import br.com.ioasys.appcamp.domain.model.Professional
import kotlinx.coroutines.flow.Flow

class ProfessionalsRemoteDataSourceImpl():ProfessionalsRemoteDataSource {

    override fun getProfessionals(accessToken: String): Flow<List<Professional>> {
        TODO("Not yet implemented")
    }
}