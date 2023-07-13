package com.example.jmcomercialapp.a_ui.menu.principal

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.jmcomercialapp.R
import com.example.jmcomercialapp.b_viewmodel.menu.MenuViewModel
import com.example.jmcomercialapp.databinding.FragmentMenuPrincipalBinding
import java.time.LocalTime

class MenuPrincipal : Fragment() {

    private lateinit var binding: FragmentMenuPrincipalBinding
    private val viewModel: MenuViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_menu_principal)
        binding = FragmentMenuPrincipalBinding.inflate(inflater, container, false)
        binding.menu = this@MenuPrincipal
        binding.viewModel = viewModel
        viewModel.setGreeting(getString(R.string.saludo_menu, getGreeting(), "Usuario")) //Reemplazar con el nombre del usuario que inició sesión
        binding.recyclerViewMenuPrincipal.adapter = MenuPrincipalAdapter()
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
        Log.d("Main", "Ir a Clientes")
        findNavController().navigate(R.id.action_menuPrincipal_to_listaClientesView)
    }

    private fun getGreeting(): String {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val time = LocalTime.now().toString()
            return when (time.subSequence(0, 2).toString().toInt()) {
                in 0..11 -> {
                    getString(R.string.goodMorning)
                }
                in 12..19 -> {
                    getString(R.string.goodAfternoon)
                }
                else -> {
                    getString(R.string.goodNight)
                }
            }
        } else {
            return getString(R.string.alternative_greeting)
        }
    }

}