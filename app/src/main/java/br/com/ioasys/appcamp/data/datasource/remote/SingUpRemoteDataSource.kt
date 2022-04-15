package br.com.ioasys.appcamp.data.datasource.remote

import br.com.ioasys.appcamp.domain.model.SignUpItems
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface SingUpRemoteDataSource {

    suspend fun singUp(
        user: String,
        email: String,
        password: String,
        confirmPassword: String,
        gender: String,
        cpf: String
    ): Response<Unit>
}