package br.com.ioasys.appcamp.domain.usecase

import br.com.ioasys.appcamp.domain.model.SingUpItems
import br.com.ioasys.appcamp.domain.respositories.SingUpRepository
import br.com.ioasys.appcamp.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class SingUpUseCase(
    private val singUpRepository: SingUpRepository,
    scope: CoroutineScope
) : UseCase<SingUpUseCase.Params, SingUpItems>(scope = scope) {

    override fun run(params: Params?): Flow<SingUpItems> {
        TODO("Not yet implemented")
    }

    data class Params(
        val user: String,
        val email: String,
        val password: String,
        val genre: String
    )
}