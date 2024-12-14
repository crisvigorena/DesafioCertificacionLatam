package com.inforcap.desafiocertificacionlatam.network.response

import com.google.gson.annotations.SerializedName
import com.inforcap.desafiocertificacionlatam.model.MovieEntity

data class MovieResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("nombre") val name: String,
    @SerializedName("logo") val logo: String

)
