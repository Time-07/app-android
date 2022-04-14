package br.com.ioasys.appcamp.data_remote.datasource

import br.com.ioasys.appcamp.data.datasource.remote.SingUpRemoteDataSource
import br.com.ioasys.appcamp.data_remote.model.SingUpResponse
import br.com.ioasys.appcamp.data_remote.service.SingUpService
import br.com.ioasys.appcamp.domain.model.SingUpItems
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SingUpRemoteDataSourceImpl(
    private val singUpService: SingUpService
) : SingUpRemoteDataSource {

    override fun singUp(
        user: String,
        email: String,
        password: String,
        confirmPassword: String,
        gender: String
    ): Flow<SingUpItems> = flow {
        singUpService.singUpUser(SingUpResponse(user, email, password, gender, roleId = "81609aa5-d934-413c-bfb9-0745fc24788b"))

    }
}