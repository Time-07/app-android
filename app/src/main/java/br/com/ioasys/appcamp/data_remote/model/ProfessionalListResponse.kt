package br.com.ioasys.appcamp.data_remote.model

import com.google.gson.annotations.SerializedName

data class ProfessionalListResponse(
    @SerializedName("")
    val data: List<ProfessionalResponse>
)