package br.com.ioasys.appcamp.data_remote.service

import br.com.ioasys.appcamp.data_remote.model.SingUpResponse
import br.com.ioasys.appcamp.domain.model.SingUpItems
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SingUpService {

    @POST("/users")
    suspend fun singUpUser(
        @Body singUpResponse: SingUpResponse
    ): Response<Unit>

}