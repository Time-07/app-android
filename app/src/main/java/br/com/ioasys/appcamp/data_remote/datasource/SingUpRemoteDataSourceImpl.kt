package br.com.ioasys.appcamp.data_remote.datasource

import br.com.ioasys.appcamp.data.datasource.remote.SingUpRemoteDataSource
import br.com.ioasys.appcamp.data_remote.model.SingUpResponse
import br.com.ioasys.appcamp.data_remote.service.SingUpService
import br.com.ioasys.appcamp.domain.model.SignUpItems
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class SingUpRemoteDataSourceImpl(
    private val singUpService: SingUpService
) : SingUpRemoteDataSource {

    override suspend fun singUp(
        user: String,
        email: String,
        password: String,
        confirmPassword: String,
        gender: String,
        cpf: String
    ): Response<Unit> {
        return singUpService.singUpUser(
            SingUpResponse(
                user,
                email,
                password,
                gender,
                cpf,
                roleId = PATIENT_ROLE_ID
            )
        )
    }
    companion object {
        private const val PATIENT_ROLE_ID = "81609aa5-d934-413c-bfb9-0745fc24788b"
    }
}