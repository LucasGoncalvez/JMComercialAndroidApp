package com.example.jmcomercialapp.b_viewmodel.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UtilsViewModel: ViewModel() {

    private val _listaCiudades = MutableLiveData<Array<String>>()
    val listaCiudades: LiveData<Array<String>>
        get() = _listaCiudades

    init {
        _listaCiudades.value = arrayOf("Areguá", "San Lorenzo", "Asunción", "Fernando de la Mora",
            "Capiatá", "Itaugua", "Ñemby", "Luque", "Coronel Bogado", "Areguá", "San Lorenzo", "Asunción", "Fernando de la Mora",
            "Capiatá", "Itaugua", "Ñemby", "Luque", "Coronel Bogado")
    }

}