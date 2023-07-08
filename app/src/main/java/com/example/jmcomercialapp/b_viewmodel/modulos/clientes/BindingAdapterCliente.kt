package com.example.jmcomercialapp.b_viewmodel.modulos.clientes

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jmcomercialapp.a_ui.modulos.clientes.principal.clases.ListaClientesAdapter
import com.example.jmcomercialapp.c_data.modulos.clientes.clases.cliente.ClientePreviewData

@BindingAdapter("listDataClientesPreview")
fun bindRecyclerViewClientesPreview(recyclerView: RecyclerView, data: MutableList<ClientePreviewData>?){
    val adapter = recyclerView.adapter as ListaClientesAdapter
    adapter.submitList(data)
}