package com.example.jmcomercialapp.a_ui.modulos.clientes.viewdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jmcomercialapp.R
import com.example.jmcomercialapp.databinding.FragmentClienteDetalleBinding

class FragmentClienteDetalle : Fragment() {

    private lateinit var binding: FragmentClienteDetalleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClienteDetalleBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun modificarCliente(){
        findNavController().navigate(R.id.action_fragmentClienteDetalle_to_ABMCliente)
    }

}