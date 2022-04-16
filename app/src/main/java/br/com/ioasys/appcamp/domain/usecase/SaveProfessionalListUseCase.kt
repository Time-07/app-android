package br.com.ioasys.appcamp.domain.usecase

import br.com.ioasys.appcamp.domain.model.Professional
import br.com.ioasys.appcamp.domain.respositories.ProfessionalsRepository
import br.com.ioasys.appcamp.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


class SaveProfessionalListUseCase(
    private val professionalsRepository: ProfessionalsRepository,
    scope: CoroutineScope
): UseCase<SaveProfessionalListUseCase.Params, Unit>(scope = scope) {

    override fun run(params: Params?): Flow<Unit> = flowOf(
        professionalsRepository.saveProfessionals(
            professionalList = params?.professionalList ?: listOf()
        )
    )

    data class Params(
        val professionalList: List<Professional>
    )

}



