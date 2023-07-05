package com.example.jmcomercialapp.a_ui.modulos.clientes.viewdetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
        Log.d("Main", "Acción para modificar el cliente") //No se está ejecutando esta acción
        //findNavController().navigate(R.id.action_fragmentContainerCliente_to_ABMCliente)
    }

}