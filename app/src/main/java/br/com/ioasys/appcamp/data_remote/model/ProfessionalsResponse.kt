package br.com.ioasys.appcamp.data_remote.model

import com.google.gson.annotations.SerializedName

data class ProfessionalsResponse(
    @SerializedName("")
    val data: List<ProfessionalRequest>
)