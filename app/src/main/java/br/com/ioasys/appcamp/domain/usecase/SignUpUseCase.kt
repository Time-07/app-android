package br.com.ioasys.appcamp.domain.usecase

import br.com.ioasys.appcamp.commons.extensions.isNotEmail
import br.com.ioasys.appcamp.domain.model.exception.EmptyInputException
import br.com.ioasys.appcamp.domain.model.exception.InvalidEmailException
import br.com.ioasys.appcamp.domain.model.exception.InvalidPasswordException
import br.com.ioasys.appcamp.domain.respositories.SingUpRepository
import br.com.ioasys.appcamp.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class SignUpUseCase(
    private val singUpRepository: SingUpRepository,
    scope: CoroutineScope
) : UseCase<SignUpUseCase.SignUpModels, Boolean>(scope = scope) {

    override fun run(params: SignUpModels?): Flow<Boolean> =
        when {
            params == null -> throw Throwable()
            params.password != params.confirmPassword -> throw InvalidPasswordException()
            params.gender.isEmpty() -> throw EmptyInputException()
            params.email.isNotEmail() -> throw InvalidEmailException()
            else -> singUpRepository.signUp(
                user = params.user,
                email = params.email,
                password = params.password,
                confirmPassword = params.confirmPassword,
                gender = params.gender,
                cpf = params.cpf
            )
        }

    data class SignUpModels(
        val user: String,
        val email: String,
        val password: String,
        val confirmPassword: String,
        val gender: String,
        val cpf: String
    )
}