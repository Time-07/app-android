package br.com.ioasys.appcamp.data.data_local.datasource


import br.com.ioasys.appcamp.data.data_local.mappers.toDao
import br.com.ioasys.appcamp.data.data_local.mappers.toDomain
import br.com.ioasys.appcamp.data.data_local.utils.LocalConstants
import br.com.ioasys.appcamp.data.data_local.utils.SharedPreferencesHelper
import br.com.ioasys.appcamp.data.datasource.local.ProfessionalsLocalDataSource
import br.com.ioasys.appcamp.data_local.database.ProfessionalDao
import br.com.ioasys.appcamp.domain.model.Professional
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProfessionalsLocalDataSourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper,
    private val professionalDao: ProfessionalDao
): ProfessionalsLocalDataSource {
    override fun getAccessToken(): Flow<String> = flow {
        emit(sharedPreferencesHelper.getString(LocalConstants.ACCESS_TOKEN_KEY))
    }

    override fun saveProfessionals(professionalList: List<Professional>) = professionalDao.addProfessionals(
        professionalList = professionalList.map { it.toDao() }
    )

    override fun getProfessionals(query: String?): Flow<List<Professional>> = flow {
        val professionalList = professionalDao.getProfessionals().map { it.toDomain() }
        query?.let {
            professionalList.map { professional ->
                professional.name.trim().contains(it,ignoreCase = true)
            }
        } ?: kotlin.run {
            emit(professionalList)
        }

    }

}