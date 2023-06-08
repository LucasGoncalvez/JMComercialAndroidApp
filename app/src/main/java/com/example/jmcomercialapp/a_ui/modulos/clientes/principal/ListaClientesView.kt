package com.example.jmcomercialapp.a_ui.modulos.clientes.principal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jmcomercialapp.R
import com.example.jmcomercialapp.databinding.FragmentListaClientesViewBinding

class ListaClientesView : Fragment() {

    private lateinit var binding: FragmentListaClientesViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaClientesViewBinding.inflate(inflater, container, false)
        binding.rvListaClientes.adapter = ListaClientesAdapter(ListaClientesDataSource().loadData())
        return binding.root
    }

}