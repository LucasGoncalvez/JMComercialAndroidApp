package com.example.jmcomercialapp.b_viewmodel.modulos.clientes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jmcomercialapp.c_data.modulos.clientes.network.ClienteApi
import com.example.jmcomercialapp.c_data.modulos.clientes.clases.cliente.ClienteDetail
import com.example.jmcomercialapp.c_data.modulos.clientes.clases.cliente.ClientePreviewData
import com.example.jmcomercialapp.c_data.modulos.clientes.clases.clientecontacto.ClienteContactoDetail
import com.example.jmcomercialapp.d_utils.MainStatuses
import kotlinx.coroutines.launch

class ClienteViewModel: ViewModel() {

    private val _status = MutableLiveData<MainStatuses>()
    val status: LiveData<MainStatuses>
        get() = _status

    private val _listaClientes = MutableLiveData<MutableList<ClientePreviewData>>()
    val listaClientes: LiveData<MutableList<ClientePreviewData>>
        get() = _listaClientes

    val _idClienteActual = MutableLiveData<Int?>(null)  //Acá se aloja el id del cliente que se seleccionará en el RecyclerView de Clientes

    private val _cliente = MutableLiveData<ClienteDetail?>()
    val cliente: LiveData<ClienteDetail?>
        get() = _cliente

    private val _statusContactos = MutableLiveData<MainStatuses>()
    val statusContactos: LiveData<MainStatuses>
        get() = _statusContactos

    private val _listaContactos = MutableLiveData<MutableList<ClienteContactoDetail>>()
    val listaContactos: LiveData<MutableList<ClienteContactoDetail>>
        get() = _listaContactos

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

    fun getClienteDetail(id: Int){
        viewModelScope.launch {
            _status.value = MainStatuses.LOADING
            try{
                val result = ClienteApi.retrofitService.getClienteDetail(id)
                _cliente.value = result
                _status.value = MainStatuses.DONE
            }
            catch (e: Exception){
                _cliente.value = null
                Log.d("Main", e.message.toString())
                _status.value = MainStatuses.ERROR
            }
        }
    }

    fun getClienteContactos(personaId: Int){
        viewModelScope.launch {
            _statusContactos.value = MainStatuses.LOADING
            try{
                val result = ClienteApi.retrofitService.getClienteContactos(personaId)
                _listaContactos.value = result
                _statusContactos.value = MainStatuses.DONE
            }
            catch (e: Exception){
                _listaContactos.value = mutableListOf()
                _statusContactos.value = MainStatuses.ERROR
                Log.d("Main", e.message.toString())
            }
        }
    }
}
