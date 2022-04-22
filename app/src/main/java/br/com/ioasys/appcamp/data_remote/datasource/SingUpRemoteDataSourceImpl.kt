package br.com.ioasys.appcamp.data_remote.datasource

import br.com.ioasys.appcamp.data.datasource.remote.SingUpRemoteDataSource
import br.com.ioasys.appcamp.data_remote.model.SingUpResponse
import br.com.ioasys.appcamp.data_remote.service.SingUpService
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
        private const val PATIENT_ROLE_ID = "f4253946-f84b-4272-b9fd-0682cfbb96ae"
    }
}