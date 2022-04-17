package br.com.ioasys.appcamp.domain.respositories

import kotlinx.coroutines.flow.Flow

interface SingUpRepository {
    fun signUp(
        user: String,
        email: String,
        password: String,
        confirmPassword: String,
        gender: String,
        cpf: String
    ): Flow<Boolean>
}