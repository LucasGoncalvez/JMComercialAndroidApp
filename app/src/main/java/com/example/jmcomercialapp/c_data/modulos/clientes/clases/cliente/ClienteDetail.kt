package com.example.jmcomercialapp.c_data.modulos.clientes.clases.cliente

import com.squareup.moshi.Json

data class ClienteDetail(

    @Json(name="id") val id: Int,
    @Json(name="nombre") val nombre: String?,
    @Json(name="apellido") val apellido: String?,
    @Json(name="tipoDocumentoId") val tipoDocumentoId: Int?,
    @Json(name="tipoDocumento") val tipoDocumento: String?,
    @Json(name="numeroDocumento") val numeroDocumento: String?,
    @Json(name="paisId") val paisId: Int,
    @Json(name="pais") val pais: String,
    @Json(name="departamentoId") val departamentoId: Int,
    @Json(name="departamento") val departamento: String,
    @Json(name="ciudadId") val ciudadId: Int,
    @Json(name="ciudad") val ciudad: String,
    @Json(name="zonaBarrioId") val zonaBarrioId: Int?,
    @Json(name="zonaBarrio") val zonaBarrio: String?,
    @Json(name="direccion") val direccion: String?,
    @Json(name="geolocalizacion") val geolocalizacion: String?,
    @Json(name="loginIdAlta") val loginIdAlta: Int?,
    @Json(name="loginAlta") val loginAlta: String?,
    @Json(name="fechaAlta") val fechaAlta: String?,
    @Json(name="loginIdUltMod") val loginIdUltMod: Int?,
    @Json(name="loginUltMod") val loginUltMod: String?,
    @Json(name="fechaUltMod") val fechaUltMod: String?,
    @Json(name="habilitado") val habilitado: Boolean
)