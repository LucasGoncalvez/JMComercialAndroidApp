package com.example.jmcomercialapp.c_data.modulos.clientes.clases.clientecontacto

data class ClienteContactoDetail(
    val id: Int,
    val personaId: Int,
    val tipoContactoId: Int,
    val tipoContacto: String,
    val valor: String,
    val descripcion: String?,
    val habilitado: Boolean
)
