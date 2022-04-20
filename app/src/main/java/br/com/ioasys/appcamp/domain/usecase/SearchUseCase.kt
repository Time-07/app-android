package br.com.ioasys.appcamp.domain.usecase

import br.com.ioasys.appcamp.domain.model.Professional
import br.com.ioasys.appcamp.domain.respositories.ProfessionalsRepository
import br.com.ioasys.appcamp.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class SearchUseCase(
    private val professionalsRepository: ProfessionalsRepository,
    scope: CoroutineScope
): UseCase<SearchUseCase.Params, List<Professional>>(scope = scope) {

    override fun run(params: Params?): Flow<List<Professional>> {
        TODO("Not yet implemented")
    }

    data class Params(
        val searchGender: String,
        val searchLocalization: String,
        val searchSpeciality: String,
        val searchName: String
    )
}