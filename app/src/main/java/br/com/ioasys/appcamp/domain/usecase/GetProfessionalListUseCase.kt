package br.com.ioasys.appcamp.domain.usecase

import br.com.ioasys.appcamp.domain.model.Professional
import br.com.ioasys.appcamp.domain.respositories.ProfessionalsRepository
import br.com.ioasys.appcamp.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetProfessionalListUseCase(
    private val professionalsRepository: ProfessionalsRepository,
    scope: CoroutineScope
) : UseCase<Unit?, List<Professional>>(scope = scope) {

    override fun run(params: Unit?): Flow<List<Professional>> = flow {
        TODO("Implement call of data's professionals")
    }
}