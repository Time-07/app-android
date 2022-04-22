package br.com.ioasys.appcamp.domain.usecase

import br.com.ioasys.appcamp.domain.model.Professional
import br.com.ioasys.appcamp.domain.respositories.ProfessionalsRepository
import br.com.ioasys.appcamp.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchUseCase(
    private val professionalsRepository: ProfessionalsRepository,
    scope: CoroutineScope
): UseCase<SearchUseCase.Params, List<Professional>>(scope = scope) {

    override fun run(params: Params?): Flow<List<Professional>> = flow{
        professionalsRepository.getProfessionals(
            gender = params?.searchGender?:"",
            city = params?.searchLocalization?:"",
            specialty = params?.searchSpecialty?:"",
            name = params?.searchName?:""
        )
    }

    data class Params(
        val searchGender: String?,
        val searchLocalization: String?,
        val searchSpecialty: String?,
        val searchName: String?
    )
}