package com.example.jmcomercialapp.a_ui.modulos.clientes.abm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.example.jmcomercialapp.R
import com.example.jmcomercialapp.b_viewmodel.utils.UtilsViewModel
import com.example.jmcomercialapp.databinding.FragmentAbmClienteBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ABMCliente : Fragment() {

    private lateinit var binding: FragmentAbmClienteBinding
    private val viewModelUtils: UtilsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.lista_clientes_fragment)
        binding = FragmentAbmClienteBinding.inflate(inflater, container, false)
        binding.abmcliente = this@ABMCliente
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //(activity as AppCompatActivity).supportActionBar?.title = getString(R.string.lista_clientes_fragment)
    }

    fun btnCiudadAction(){
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Elige una ciudad")
            .setPositiveButton("Aceptar"){ dialog, which ->
                showToast("$which")
            }
            .setNegativeButton("Cancelar"){ dialog, which ->
                dialog.dismiss()
            }
            .setSingleChoiceItems(viewModelUtils.listaCiudades.value, 1) { dialog, which ->
                showToast(viewModelUtils.listaCiudades.value!![which])
            }
            .show()
    }

    fun btnAddGeolocationAction(){
        showToast("Próximamente...")
    }

    private fun showToast(msg: String){
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

}