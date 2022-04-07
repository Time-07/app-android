package br.com.ioasys.appcamp.data.repositories

import br.com.ioasys.appcamp.domain.model.User
import br.com.ioasys.appcamp.domain.respositories.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRepositoryImpl : LoginRepository {

    override fun login(
        email: String,
        password: String,

    ): Flow<User> = flow {

    }
}