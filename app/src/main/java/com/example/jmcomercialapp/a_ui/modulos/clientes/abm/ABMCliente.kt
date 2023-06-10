package com.example.jmcomercialapp.a_ui.modulos.clientes.abm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jmcomercialapp.R
import com.example.jmcomercialapp.databinding.FragmentAbmClienteBinding

class ABMCliente : Fragment() {

    private lateinit var binding: FragmentAbmClienteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAbmClienteBinding.inflate(inflater, container, false)
        return binding.root
    }

}