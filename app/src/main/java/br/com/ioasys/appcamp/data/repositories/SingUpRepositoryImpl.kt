package br.com.ioasys.appcamp.data.repositories

import br.com.ioasys.appcamp.data.datasource.remote.SingUpRemoteDataSource
import br.com.ioasys.appcamp.domain.model.SingUpItems
import br.com.ioasys.appcamp.domain.respositories.SingUpRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SingUpRepositoryImpl(
    private val singUpRemoteDataSource: SingUpRemoteDataSource
): SingUpRepository {

    override fun singUp(
        user: String,
        email: String,
        password: String,
        confirmPassword: String,
        gender: String
    ): Flow<SingUpItems> = flow {
        emit(SingUpItems(user, email, password, confirmPassword, gender))
    }
}