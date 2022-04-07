package br.com.ioasys.appcamp.data.repositories

import br.com.ioasys.appcamp.domain.model.SingUpItems
import br.com.ioasys.appcamp.domain.respositories.SingUpRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SingUpRepositoryImpl: SingUpRepository {

    override fun singUp(
        user: String,
        email: String,
        password: String,
        confirmPassword: String,
        genre: String
    ): Flow<SingUpItems> = flow {

    }
}