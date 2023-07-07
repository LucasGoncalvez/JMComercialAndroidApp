package com.example.jmcomercialapp.c_data.modulos.clientes.network

import com.squareup.moshi.Json

data class ClientePreviewData(
    @Json(name="id") val id: Int,
    @Json(name="nombre") val nombre: String?,
    @Json(name="apellido") val apellido: String?,
    @Json(name="tipoDocumento") val tipoDocumento: String?,
    @Json(name="numeroDocumento") val numeroDocumento: String?,
    @Json(name="ciudad") val ciudad: String?
)
