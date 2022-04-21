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
    private val professionalsLocalDataSource: ProfessionalsLocalDataSource,
) : ProfessionalsRepository {
    override fun getAllProfessionals(accessToken: String): Flow<List<Professional>> = flow {
        professionalsLocalDataSource.getAccessToken().collect { accessToken ->
            professionalsRemoteDataSource.getAllProfessionalsList(accessToken = accessToken).collect {
                emit(it)
            }
        }
    }

    override fun getProfessionals(
        gender: String,
        name: String,
        specialty: String,
        city: String
    ): Flow<List<Professional>> = flow {
        professionalsLocalDataSource.getAccessToken().collect { token ->
            if (token.isNotEmpty()) {
                professionalsRemoteDataSource.getProfessionalsListFiltered(gender, city, specialty, name, token).collect{
                    emit(it)
                }
            }
        }
    }

    override fun saveProfessionals(professionalList: List<Professional>) =
        professionalsLocalDataSource.saveProfessionals(
            professionalList = professionalList
        )
}