package br.com.ioasys.appcamp.data.repositories

import br.com.ioasys.appcamp.data.datasource.local.LoginLocalDataSource
import br.com.ioasys.appcamp.data.datasource.remote.LoginRemoteDataSource
import br.com.ioasys.appcamp.domain.model.User
import br.com.ioasys.appcamp.domain.respositories.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class LoginRepositoryImpl(
    private val loginRemoteDataSource: LoginRemoteDataSource,
    private val loginLocalDataSource: LoginLocalDataSource

) : LoginRepository {
    override fun login(email: String, password: String): Flow<User> = flow {
        loginRemoteDataSource.login(email, password).collect { userData ->
            loginLocalDataSource.saveAccessToken(accessToken = userData.accessToken)

            emit(userData)
        }

    }
}