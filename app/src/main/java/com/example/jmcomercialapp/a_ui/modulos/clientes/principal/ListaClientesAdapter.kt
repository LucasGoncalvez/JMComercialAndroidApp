package com.example.jmcomercialapp.a_ui.modulos.clientes.principal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jmcomercialapp.R

class ListaClientesAdapter(private val listData: List<ClienteItem>):
    RecyclerView.Adapter<ListaClientesAdapter.ListaClientesViewHolder>(){

    class ListaClientesViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val nombre = item.findViewById<TextView>(R.id.tvNombreClienteItem)
        val apellido = item.findViewById<TextView>(R.id.tvApellidoClienteItem)
        val ciudad = item.findViewById<TextView>(R.id.tvCiudadClienteItem)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListaClientesViewHolder {
        return ListaClientesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_item_lista_clientes_view, parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ListaClientesViewHolder,
        position: Int
    ) {
        val item = listData[position]
        holder.apply {
            nombre.text = item.nombre
            apellido.text = item.apellido
            ciudad.text = item.ciudad
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}