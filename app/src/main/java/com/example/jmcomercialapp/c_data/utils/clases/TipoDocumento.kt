package com.example.jmcomercialapp.c_data.utils.clases

import com.squareup.moshi.Json

data class TipoDocumento(
    @Json(name="id") val id: Int,
    @Json(name="denominacion") val denominacion: String,
    @Json(name="abreviatura") val abreviatura: String?,
    @Json(name="habilitado") val habilitado: Boolean
){
    override fun toString(): String {
        return denominacion
    }
}
