package com.inforcap.desafiocertificacionlatam.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FigureDetailEntity(
        @SerializedName("id")
         val id: Int,
        @SerializedName("nombre")
        val nombre: String,
        @SerializedName("logo")
        val logo: String,
        @SerializedName("fecha_creacion")
        val fecha_creacion: String,
        @SerializedName("origen")
        val origen: String,
        @SerializedName("pelicula")
        val pelicula: String,
        @SerializedName("descripcion")
        val descripcion: String,
        @SerializedName("colores")
        val colores: List<String>,
        @SerializedName("disponibilidad")
        val disponibilidad: Boolean,
        @SerializedName("precio")
        val precio: Long
) : Parcelable

