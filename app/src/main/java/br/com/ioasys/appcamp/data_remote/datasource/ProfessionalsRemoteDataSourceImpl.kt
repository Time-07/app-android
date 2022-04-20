package br.com.ioasys.appcamp.data_remote.datasource

import br.com.ioasys.appcamp.data.datasource.remote.ProfessionalsRemoteDataSource
import br.com.ioasys.appcamp.data_remote.mappers.toDomain
import br.com.ioasys.appcamp.data_remote.service.ProfessionalService
import br.com.ioasys.appcamp.domain.model.Professional
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProfessionalsRemoteDataSourceImpl(
    private val professionalService: ProfessionalService
):ProfessionalsRemoteDataSource{

    override fun getAllProfessionalsList(accessToken: String): Flow<List<Professional>>  = flow{
        val response = professionalService.getAllProfessionalsList(accessToken = "Bearer $accessToken")
        if(response.isSuccessful){
            response.body()?.data?.toDomain()
        }
    }

    override fun getProfessionalsListFiltered(
        accessToken: String,
        gender: String?,
        specialty: String?,
        city: String?,
        name: String?
    ): Flow<List<Professional>> = flow {
        val response = professionalService.getListFilteredProfessionals(
            accessToken = "Bearer $accessToken",
            gender?:"",
            specialty?:"",
            city?:"",
            name?:"")

        if (response.isSuccessful){
            response.body()?.data?.let { remoteList ->
                (gender.isNullOrEmpty()&&specialty.isNullOrEmpty()&&city.isNullOrEmpty()&&name.isNullOrEmpty()).toString().let {
                    emit(remoteList.filter { professional ->
                        professional.gender?.trim()?.contains(it , ignoreCase = true)?: false
                        professional.specialty?.trim()?.contains(it , ignoreCase = true)?: false
                        professional.city?.trim()?.contains(it , ignoreCase = true)?: false
                        professional.name?.trim()?.contains(it , ignoreCase = true)?: false
                    }.toDomain())
                }
            }
        }
    }
}