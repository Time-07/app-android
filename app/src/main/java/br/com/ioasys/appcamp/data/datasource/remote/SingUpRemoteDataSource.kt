package br.com.ioasys.appcamp.data.datasource.remote

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