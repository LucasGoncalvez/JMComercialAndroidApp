package com.example.jmcomercialapp.c_data.utils.clases

import com.squareup.moshi.Json

data class Ciudad(
    @Json(name = "id") val id: Int,
    @Json(name = "paisId") val paisId: Int,
    @Json(name = "departamentoId") val departamentoId: Int,
    @Json(name = "denominacion") val denominacion: String,
    @Json(name = "iso") val iso: Int?
) {
    override fun toString(): String {
        return denominacion
    }
}
