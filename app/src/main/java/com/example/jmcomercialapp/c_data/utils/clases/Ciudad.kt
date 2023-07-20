package com.example.jmcomercialapp.c_data.utils.clases

import com.squareup.moshi.Json

data class Ciudad(
    @Json(name = "id") val id: Int,
    @Json(name = "departamentoId") val departamentoId: Int,
    @Json(name = "denominacion") val denominacion: String,
    @Json(name = "iso") val iso: Int?
) {
    override fun toString(): String {
        return denominacion
    }
}

class CiudadDataSource() {
    fun loadCities(): Array<Ciudad> {
        return arrayOf(
            Ciudad(1, 1, "Areguá", null),
            Ciudad(2, 1, "Capiatá", null),
            Ciudad(3, 1, "San Lorenzo", null),
            Ciudad(4, 1, "Fernando de la Mora", null),
            Ciudad(5, 1, "Asunción", null),
            Ciudad(6, 1, "Ñemby", null),
            Ciudad(7, 1, "Ypane", null),
            Ciudad(8, 1, "Limpio", null),
            Ciudad(9, 1, "Lambare", null),
            Ciudad(10, 1, "Itaugua", null),
            Ciudad(11, 1, "Coronel Bogado", null),
            Ciudad(12, 1, "Luque", null)
        )
    }

}