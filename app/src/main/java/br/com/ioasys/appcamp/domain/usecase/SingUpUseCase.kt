package br.com.ioasys.appcamp.domain.usecase

import br.com.ioasys.appcamp.domain.exception.EmptyInputException
import br.com.ioasys.appcamp.domain.exception.InvalidEmailException
import br.com.ioasys.appcamp.domain.exception.InvalidPasswordException
import br.com.ioasys.appcamp.domain.model.SingUpItems
import br.com.ioasys.appcamp.domain.respositories.SingUpRepository
import br.com.ioasys.appcamp.domain.utils.DomainConstants
import br.com.ioasys.appcamp.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class SingUpUseCase(
    private val singUpRepository: SingUpRepository,
    scope: CoroutineScope
) : UseCase<SingUpUseCase.Params, SingUpItems>(scope = scope) {

    override fun run(params: Params?): Flow<SingUpItems> = when {
        params?.password != params?.confirmPassword -> throw InvalidPasswordException()
        params?.genre?.isEmpty() == true -> throw EmptyInputException()
        params?.email?.let { DomainConstants.EMAIL_REGEX.toRegex().matches(it) } == true -> throw InvalidEmailException()
        else -> {
            singUpRepository.singUp(
                user = params?.user ?: "",
                email = params?.email ?: "",
                password = params?.password ?: "",
                confirmPassword = params?.confirmPassword ?:"",
                genre = params?.genre ?: ""
            )
        }
    }

    data class Params(
        val user: String,
        val email: String,
        val password: String,
        val confirmPassword: String,
        val genre: String
    )
}