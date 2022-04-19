package br.com.ioasys.appcamp.data_remote.service

import br.com.ioasys.appcamp.data_remote.model.ProfessionalRequest
import br.com.ioasys.appcamp.data_remote.model.ProfessionalsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface ProfessionalService {

    @GET("/api/v1/users/{id}")
    suspend fun getListProfessionals(): Response<ProfessionalsResponse>
}