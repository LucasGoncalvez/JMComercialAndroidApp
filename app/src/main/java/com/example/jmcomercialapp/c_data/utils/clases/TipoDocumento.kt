package com.example.jmcomercialapp.c_data.utils.clases

import com.squareup.moshi.Json

data class TipoDocumento(
    @Json(name="id") val id: Int,
    @Json(name="denominacion") val denominacion: String,
    @Json(name="habilitado") val habilitado: Boolean
){
    override fun toString(): String {
        return denominacion
    }
}

class TipoDocumentoDataSource{
    fun load(): Array<TipoDocumento>{
        return arrayOf(
            TipoDocumento(1, "Cédula de Identidad", true),
            TipoDocumento(2, "Pasaporte", true),
            TipoDocumento(3, "Registro de Conducir", true),
            TipoDocumento(4, "Registro Único del Contribuyente", true)
        )
    }
}
