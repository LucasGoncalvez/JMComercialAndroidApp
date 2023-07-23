package com.example.jmcomercialapp.b_viewmodel.utils

import android.content.Context
import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jmcomercialapp.R
import com.example.jmcomercialapp.c_data.utils.clases.Ciudad
import com.example.jmcomercialapp.c_data.utils.network.UtilsApi
import kotlinx.coroutines.launch

class UtilsViewModel: ViewModel() {

    private val _listCities = MutableLiveData<Array<Ciudad>>(arrayOf())
    val listCities: LiveData<Array<Ciudad>>
        get() = _listCities

    var selectedCity = MutableLiveData<Ciudad>()

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    init {
        initCity()
        _status.value = "Inicializado"
    }

    fun getCities(){
        viewModelScope.launch {
            try{
                val result = UtilsApi.retrofitService.getCities()
                _listCities.value = result
            }
            catch (e: Exception){
                Log.d("Main", e.message.toString())
                _listCities.value = arrayOf()
                _status.value = e.message
            }
        }
    }

    fun initCity(){
        //Si es que es para insercición, inicializar con id = -1, si es para modificación, poner la ciudad correspondiente
        selectedCity.value = Ciudad(-1, -1, -1,"(Ninguno)"/*Resources.getSystem().getString(R.string.caption_selected_empty)*/, null)
    }

}
