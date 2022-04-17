package br.com.ioasys.appcamp.domain.usecase

import br.com.ioasys.appcamp.domain.model.Professional
import br.com.ioasys.appcamp.domain.respositories.ProfessionalsRepository
import br.com.ioasys.appcamp.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetProfessionalListUseCase(
    private val professionalsRepository: ProfessionalsRepository,
    scope: CoroutineScope
) : UseCase<GetProfessionalListUseCase.Params, List<Professional>>(scope = scope) {

    override fun run(params: Params?): Flow<List<Professional>> = professionalsRepository.getProfessionals(
    query = params?.input
    )

    data class Params(
        val input: String
    )

}