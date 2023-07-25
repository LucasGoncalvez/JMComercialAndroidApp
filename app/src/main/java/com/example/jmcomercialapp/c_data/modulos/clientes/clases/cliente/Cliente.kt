package com.example.jmcomercialapp.c_data.modulos.clientes.clases.cliente

import com.squareup.moshi.Json

data class Cliente(
    @Json(name="id") val id: Int,
    @Json(name="nombre") val nombre: String,
    @Json(name="apellido") val apellido: String?,
    @Json(name="tipoDocumentoId") val tipoDocumentoId: Int?,
    @Json(name="numeroDocumento") val numeroDocumento: String?,
    @Json(name="paisId") val paisId: Int,
    @Json(name="departamentoId") val departamentoId: Int,
    @Json(name="ciudadId") val ciudadId: Int,
    @Json(name="zonaBarrioId") val zonaBarrioId: Int?,
    @Json(name="direccion") val direccion: String?,
    @Json(name="geolocalizacion") val geolocalizacion: String?,
    @Json(name="loginIdAlta") val loginIdAlta: Int?,
    @Json(name="fechaAlta") val fechaAlta: String?,
    @Json(name="loginIdUltMod") val loginIdUltMod: Int?,
    @Json(name="fechaUltMod") val fechaUltMod: String?,
    @Json(name="habilitado") val habilitado: Boolean
)