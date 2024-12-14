package com.inforcap.desafiocertificacionlatam.model

import com.google.gson.annotations.SerializedName

data class MovieEntity(

    @SerializedName("id")
    var id: Int,
    @SerializedName("nombre")
    var nombre: String,
    @SerializedName("logo")
    var logo: String

)
