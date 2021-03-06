package br.com.ioasys.appcamp.domain.respositories

import br.com.ioasys.appcamp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun login(email: String, password: String) : Flow<User>
}
