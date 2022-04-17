package br.com.ioasys.appcamp.data.repositories

import br.com.ioasys.appcamp.data.datasource.local.ProfessionalsLocalDataSource
import br.com.ioasys.appcamp.data.datasource.remote.ProfessionalsRemoteDataSource
import br.com.ioasys.appcamp.domain.model.Professional
import br.com.ioasys.appcamp.domain.respositories.ProfessionalsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class ProfessionalsRepositoryImpl(
    private val professionalsRemoteDataSource: ProfessionalsRemoteDataSource,
    private val professionalsLocalDataSource: ProfessionalsLocalDataSource
): ProfessionalsRepository {

    override fun getProfessionals(query: String?): Flow<List<Professional>> = flow{
        professionalsLocalDataSource.getAccessToken().collect { token ->
            if (token.isNotEmpty()) {
                professionalsRemoteDataSource.getProfessionals(token, query).collect { professionalList ->
                    emit(professionalList)
                }
            } else {
                professionalsLocalDataSource.getProfessionals(query = query).collect { professionalList ->
                    emit(professionalList)
                }
            }
        }

    }

    override fun saveProfessionals(professionalList: List<Professional>) = professionalsLocalDataSource.saveProfessionals(
        professionalList = professionalList
    )
}