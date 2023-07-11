package com.example.jmcomercialapp.a_ui.login.iniciosesion.principal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.jmcomercialapp.R
import com.example.jmcomercialapp.databinding.FragmentInicioSesionBinding

class InicioSesion : Fragment() {

    private lateinit var binding: FragmentInicioSesionBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.title = ""
        binding = FragmentInicioSesionBinding.inflate(inflater, container, false)
        binding.iniciosesion = this@InicioSesion
        return binding.root
    }

    fun goToMenuPrincipal(){
        findNavController().navigate(R.id.action_inicioSesion_to_menuPrincipal)
    }

}