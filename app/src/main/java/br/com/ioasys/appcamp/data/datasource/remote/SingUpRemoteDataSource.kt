package br.com.ioasys.appcamp.data.datasource.remote

import br.com.ioasys.appcamp.domain.model.SingUpItems
import kotlinx.coroutines.flow.Flow

interface SingUpRemoteDataSource {

    fun singUp(user: String, email: String, password: String, confirmPassword: String, gender: String): Flow<SingUpItems>
}