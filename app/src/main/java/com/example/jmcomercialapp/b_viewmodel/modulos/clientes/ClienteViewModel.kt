package com.example.jmcomercialapp.b_viewmodel.modulos.clientes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jmcomercialapp.c_data.modulos.clientes.network.ClienteApi
import kotlinx.coroutines.launch

class ClienteViewModel: ViewModel() {

    private var _statusClientesPreview = MutableLiveData<String>()
    val statusClientesPreview: LiveData<String>
        get() = _statusClientesPreview

    fun getClientesPreview(){
        viewModelScope.launch {
            try{
                val result = ClienteApi.retrofitService.getClientesPreview()
                _statusClientesPreview.value = "Cantidad: ${result.size}"
            }
            catch (e: Exception){
                _statusClientesPreview.value = "Error: ${e.message}"
            }
        }
    }
}