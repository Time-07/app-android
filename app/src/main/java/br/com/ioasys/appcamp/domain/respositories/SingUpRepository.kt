package br.com.ioasys.appcamp.domain.respositories

import br.com.ioasys.appcamp.domain.model.SingUpItems
import kotlinx.coroutines.flow.Flow

interface SingUpRepository {

    fun singUp(user: String, email: String, password: String, genre: String): Flow<SingUpItems>
}