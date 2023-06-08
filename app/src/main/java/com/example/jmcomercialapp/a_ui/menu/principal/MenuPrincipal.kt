package com.example.jmcomercialapp.a_ui.menu.principal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.jmcomercialapp.R
import com.example.jmcomercialapp.b_viewmodel.menu.MenuViewModel
import com.example.jmcomercialapp.databinding.FragmentMenuPrincipalBinding

class MenuPrincipal : Fragment() {

    private lateinit var binding: FragmentMenuPrincipalBinding
    private val viewModel: MenuViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuPrincipalBinding.inflate(inflater, container, false)
        binding.menu = this@MenuPrincipal
        return binding.root
    }

    fun goToVentasArticulos(){
        findNavController().navigate(R.id.action_menuPrincipal_to_listaVentaArticulosView)
    }

    fun goToPrestamos(){
        findNavController().navigate(R.id.action_menuPrincipal_to_listaPrestamosView)
    }

    fun goToInventario(){
        findNavController().navigate(R.id.action_menuPrincipal_to_listaInventarioView)
    }

    fun gotToClientes(){
        findNavController().navigate(R.id.action_menuPrincipal_to_listaClientesView)
    }

}