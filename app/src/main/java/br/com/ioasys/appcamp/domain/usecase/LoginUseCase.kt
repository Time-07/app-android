package br.com.ioasys.appcamp.domain.usecase

import br.com.ioasys.appcamp.domain.exception.InvalidEmailException
import br.com.ioasys.appcamp.domain.exception.InvalidPasswordException
import br.com.ioasys.appcamp.domain.model.User
import br.com.ioasys.appcamp.domain.respositories.LoginRepository
import br.com.ioasys.appcamp.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class LoginUseCase(
    private val loginRepository: LoginRepository,
    scope: CoroutineScope

): UseCase<LoginUseCase.Params, User>(scope = scope) {

    override fun run(params: Params?): Flow<User> = when {
        params?.email?.isEmpty() == true -> throw InvalidEmailException()
        params?.password?.isEmpty() == true -> throw InvalidPasswordException()
        else ->  loginRepository.login(
            email = params?.email ?: "",
            password = params?.password ?: ""
        )
    }

    data class  Params(
        val email: String,
        val password: String
    )

}
