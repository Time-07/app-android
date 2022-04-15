package br.com.ioasys.appcamp.data.repositories

import br.com.ioasys.appcamp.data.datasource.remote.SingUpRemoteDataSource
import br.com.ioasys.appcamp.domain.model.SignUpItems
import br.com.ioasys.appcamp.domain.respositories.SingUpRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class SingUpRepositoryImpl(
    private val singUpRemoteDataSource: SingUpRemoteDataSource
): SingUpRepository {

    override fun signUp(
        user: String,
        email: String,
        password: String,
        confirmPassword: String,
        gender: String,
        cpf: String
    ): Flow<Boolean> = flow {
        val response = singUpRemoteDataSource.singUp(
            user,
            email,
            password,
            confirmPassword,
            gender,
            cpf
        )
        emit(response.isSuccessful)
    }
}