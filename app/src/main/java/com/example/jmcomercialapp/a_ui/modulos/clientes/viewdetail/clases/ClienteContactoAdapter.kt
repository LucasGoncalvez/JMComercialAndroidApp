package com.example.jmcomercialapp.a_ui.modulos.clientes.viewdetail.clases

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jmcomercialapp.c_data.modulos.clientes.clases.clientecontacto.ClienteContactoDetail
import com.example.jmcomercialapp.databinding.LayoutItemContactoBinding

class ClienteContactoAdapter:
    ListAdapter<ClienteContactoDetail, ClienteContactoAdapter.ClienteContactoViewHolder>(DiffCallback) {

    class ClienteContactoViewHolder(private val binding: LayoutItemContactoBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(contacto: ClienteContactoDetail){
            binding.contacto = contacto
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteContactoViewHolder {
        return ClienteContactoViewHolder(
            LayoutItemContactoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ClienteContactoViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    companion object DiffCallback: DiffUtil.ItemCallback<ClienteContactoDetail>() {
        override fun areItemsTheSame(
            oldItem: ClienteContactoDetail,
            newItem: ClienteContactoDetail
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ClienteContactoDetail,
            newItem: ClienteContactoDetail
        ): Boolean {
            return oldItem.tipoContactoId == newItem.tipoContactoId
                    && oldItem.valor == newItem.valor
        }

    }
}