package com.example.jmcomercialapp.b_viewmodel.utils

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jmcomercialapp.c_data.utils.clases.Ciudad
import com.example.jmcomercialapp.c_data.utils.clases.TipoDocumento
import com.example.jmcomercialapp.c_data.utils.network.UtilsApi
import com.example.jmcomercialapp.d_utils.LOG_TAG
import kotlinx.coroutines.launch

class UtilsViewModel: ViewModel() {

    private val _listCities = MutableLiveData<Array<Ciudad>>(arrayOf())
    val listCities: LiveData<Array<Ciudad>>
        get() = _listCities

    private val _listDocTypes = MutableLiveData<Array<TipoDocumento>>(arrayOf())
    val listDocTypes: LiveData<Array<TipoDocumento>>
        get() = _listDocTypes

    var selectedCity = MutableLiveData<Ciudad>()

    var selectedDocType = MutableLiveData<TipoDocumento>()

    private val _statusCities = MutableLiveData<String>()
    val statusCities: LiveData<String>
        get() = _statusCities

    private val _statusDocTypes = MutableLiveData<String>()
    val statusDocTypes: LiveData<String>
        get() = _statusDocTypes

    init {
        initCity()
        initDocType()
    }

    fun getCities(ciudadId: Int){
        /*Recibe -1 cuando se va registrar al cliente, porque no tiene aun asignada ninguna ciudad
        Recibe el id de la ciudad actual del cliente cuando se va modificar los datos de un cliente,
        porque ya tiene asignada una ciudad*/
        viewModelScope.launch {
            try{
                val result = UtilsApi.retrofitService.getCities()
                result.sortBy { it.denominacion }
                _listCities.value = result
                if(ciudadId > -1){
                    val currentCity = listCities.value?.filter { it.id == ciudadId }!!.first()
                    selectedCity.value = currentCity
                }
            }
            catch (e: Exception){
                Log.d("Main", e.message.toString())
                _listCities.value = arrayOf()
            }
        }
    }

    fun getDocTypes(){
        viewModelScope.launch {
            try{
                val result = UtilsApi.retrofitService.getTiposDocumentos()
                _listDocTypes.value = result
            }
            catch (e: Exception){
                Log.d("Main", e.message.toString())
                _listDocTypes.value = arrayOf()
            }
        }
    }

    fun initCity(){
        //Si es que es para insercición, inicializar con id = -1, si es para modificación, poner la ciudad correspondiente
        selectedCity.value = Ciudad(-1, -1, -1,"(Ninguno)"/*Resources.getSystem().getString(R.string.caption_selected_empty)*/, null)
    }

    fun initDocType(){
        selectedDocType.value = TipoDocumento(-1, "(Ninguno)", null,true)
    }

}
