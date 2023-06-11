package com.example.jmcomercialapp.a_ui.modulos.clientes.principal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.jmcomercialapp.R
import com.example.jmcomercialapp.a_ui.modulos.clientes.principal.clases.ListaClientesAdapter
import com.example.jmcomercialapp.a_ui.modulos.clientes.principal.clases.ListaClientesDataSource
import com.example.jmcomercialapp.databinding.FragmentListaClientesViewBinding

class ListaClientesView : Fragment() {

    private lateinit var binding: FragmentListaClientesViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaClientesViewBinding.inflate(inflater, container, false)
        binding.listaclientesview = this@ListaClientesView
        binding.rvListaClientes.adapter = ListaClientesAdapter(ListaClientesDataSource().loadData())
        return binding.root
    }

    fun goToRegistrarCliente(){
        findNavController().navigate(R.id.action_listaClientesView_to_ABMCliente)
    }

    fun goToClienteDetalle(){
        findNavController().navigate(R.id.action_listaClientesView_to_fragmentContainerCliente)
    }

    private fun showToast(msg: String){
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

}