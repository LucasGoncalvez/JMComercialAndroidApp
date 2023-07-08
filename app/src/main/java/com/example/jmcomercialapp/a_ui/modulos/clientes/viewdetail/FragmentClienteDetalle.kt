package com.example.jmcomercialapp.a_ui.modulos.clientes.viewdetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.jmcomercialapp.R
import com.example.jmcomercialapp.b_viewmodel.modulos.clientes.ClienteViewModel
import com.example.jmcomercialapp.databinding.FragmentClienteDetalleBinding

class FragmentClienteDetalle(private val clienteId: Int) : Fragment() {

    private lateinit var binding: FragmentClienteDetalleBinding
    private val viewModel: ClienteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel._idClienteActual.value = clienteId
        Log.d("Main", "Id del cliente en onCreate(): ${viewModel._idClienteActual.value}")
        viewModel.getClienteDetail(clienteId)
        viewModel.getClienteContactos(clienteId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClienteDetalleBinding.inflate(inflater, container, false)
        binding.clientedetalle = this@FragmentClienteDetalle
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        Log.d("Main", "Id del cliente en onCreateView(): ${viewModel._idClienteActual.value}")
        return binding.root
    }

    fun modificarCliente(){
        Log.d("Main", "${viewModel.listaContactos.value?.size}")
        //findNavController().navigate(R.id.action_fragmentContainerCliente_to_ABMCliente)
    }

}