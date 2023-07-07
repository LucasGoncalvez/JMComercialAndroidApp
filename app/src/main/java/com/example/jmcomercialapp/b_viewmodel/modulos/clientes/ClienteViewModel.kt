package com.example.jmcomercialapp.b_viewmodel.modulos.clientes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jmcomercialapp.c_data.modulos.clientes.network.ClienteApi
import com.example.jmcomercialapp.c_data.modulos.clientes.network.ClientePreviewData
import com.example.jmcomercialapp.d_utils.MainStatuses
import kotlinx.coroutines.launch

class ClienteViewModel: ViewModel() {

    private var _status = MutableLiveData<MainStatuses>()
    val status: LiveData<MainStatuses>
        get() = _status

    private val _listaClientes = MutableLiveData<MutableList<ClientePreviewData>>()
    val listaClientes: LiveData<MutableList<ClientePreviewData>>
        get() = _listaClientes

    val _idClienteActual = MutableLiveData<Int?>(null)  //Acá se aloja el id del cliente que se seleccionará en el RecyclerView de Clientes

    fun getClientesPreview(){
        viewModelScope.launch {
            _status.value = MainStatuses.LOADING
            try{
                val result = ClienteApi.retrofitService.getClientesPreview()
                _listaClientes.value = result
                _status.value = MainStatuses.DONE

            }
            catch (e: Exception){
                _listaClientes.value = mutableListOf()
                _status.value = MainStatuses.ERROR
            }
        }
    }
}