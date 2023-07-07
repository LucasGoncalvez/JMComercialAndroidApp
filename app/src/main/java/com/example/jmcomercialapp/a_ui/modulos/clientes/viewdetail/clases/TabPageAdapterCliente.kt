package com.example.jmcomercialapp.a_ui.modulos.clientes.viewdetail.clases

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.jmcomercialapp.a_ui.modulos.clientes.viewdetail.FragmentClienteDetalle
import com.example.jmcomercialapp.a_ui.modulos.clientes.viewdetail.FragmentClienteHistorialTarjetas

class TabPageAdapterCliente(fragmentContainer: Fragment, private val tabCount: Int, private val clienteId: Int):
    FragmentStateAdapter(fragmentContainer){
    override fun getItemCount(): Int {
        return tabCount
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FragmentClienteDetalle(clienteId)
            else -> FragmentClienteHistorialTarjetas()
        }
    }

}