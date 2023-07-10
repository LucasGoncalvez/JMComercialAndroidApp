package com.example.jmcomercialapp.b_viewmodel.modulos.clientes

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jmcomercialapp.a_ui.modulos.clientes.principal.clases.ListaClientesAdapter
import com.example.jmcomercialapp.a_ui.modulos.clientes.viewdetail.clases.ClienteContactoAdapter
import com.example.jmcomercialapp.c_data.modulos.clientes.clases.cliente.ClientePreviewData
import com.example.jmcomercialapp.c_data.modulos.clientes.clases.clientecontacto.ClienteContactoDetail

@BindingAdapter("listDataClientesPreview")
fun bindRecyclerViewClientesPreview(recyclerView: RecyclerView, data: MutableList<ClientePreviewData>?){
    val adapter = recyclerView.adapter as ListaClientesAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataClienteContactoPreview")
fun bindRecyclerViewClienteContactoPreview(recyclerView: RecyclerView, data: MutableList<ClienteContactoDetail>?){
    val adapter = recyclerView.adapter as ClienteContactoAdapter
    adapter.submitList(data)
}