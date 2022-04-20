package br.com.ioasys.appcamp.data_remote.service

import br.com.ioasys.appcamp.data_remote.model.ProfessionalListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ProfessionalService {

    @GET("/api/v1/users/?")
    suspend fun getListFilteredProfessionals(
        @Header("authorization") accessToken: String,
        @Query("gender") gender: String,
        @Query("specialty") specialty: String,
        @Query("city") city: String
    ): Response<ProfessionalListResponse>

    @GET("/api/v1/users")
    suspend fun getAllProfessionalsList(
        @Header("authorization") accessToken: String
    ): Response<ProfessionalListResponse>
}