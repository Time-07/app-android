package br.com.ioasys.appcamp.data_remote.service

import br.com.ioasys.appcamp.data_remote.model.SingUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SingUpService {

    @POST("/api/v1/users")
    suspend fun singUpUser(
        @Body singUpResponse: SingUpResponse
    ): Response<Unit>

}