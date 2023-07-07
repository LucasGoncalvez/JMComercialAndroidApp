package com.example.jmcomercialapp.a_ui.modulos.clientes.principal.clases

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jmcomercialapp.c_data.modulos.clientes.network.ClientePreviewData
import com.example.jmcomercialapp.databinding.LayoutItemListaClientesViewBinding
//import androidx.recyclerview.widget

class ListaClientesAdapter():
    ListAdapter<ClientePreviewData, ListaClientesAdapter.ListaClientesViewHolder>(DiffCallback){

    class ListaClientesViewHolder(private var binding: LayoutItemListaClientesViewBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cliente: ClientePreviewData){
            binding.cliente = cliente
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListaClientesViewHolder {
        return ListaClientesViewHolder(
            LayoutItemListaClientesViewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ListaClientesViewHolder,
        position: Int
    ) {
        val cliente = getItem(position)
        holder.bind(cliente)
    }

    companion object DiffCallback: DiffUtil.ItemCallback<ClientePreviewData>(){
        override fun areItemsTheSame(
            oldItem: ClientePreviewData,
            newItem: ClientePreviewData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ClientePreviewData,
            newItem: ClientePreviewData
        ): Boolean {
            return oldItem.nombre == newItem.nombre
                    && oldItem.apellido == newItem.apellido
                    && oldItem.tipoDocumento == newItem.tipoDocumento
                    && oldItem.numeroDocumento == newItem.numeroDocumento
        }

    }

}