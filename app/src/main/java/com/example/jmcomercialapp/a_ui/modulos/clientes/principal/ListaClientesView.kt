package com.example.jmcomercialapp.a_ui.modulos.clientes.principal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.jmcomercialapp.R
import com.example.jmcomercialapp.a_ui.modulos.clientes.principal.clases.ListaClientesAdapter
import com.example.jmcomercialapp.a_ui.modulos.clientes.principal.clases.ListaClientesDataSource
import com.example.jmcomercialapp.b_viewmodel.modulos.clientes.ClienteViewModel
import com.example.jmcomercialapp.databinding.FragmentListaClientesViewBinding

class ListaClientesView : Fragment() {

    private lateinit var binding: FragmentListaClientesViewBinding
    private val viewModel: ClienteViewModel by viewModels() //activityViewModels()
    private lateinit var adapter: ListaClientesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.lista_clientes_fragment)
        binding = FragmentListaClientesViewBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.getClientesPreview()
        binding.listaclientesview = this@ListaClientesView
        binding.viewModel = viewModel
        adapter = ListaClientesAdapter()
        binding.rvListaClientes.adapter = adapter
        adapter.onItemClick = { goToClienteDetalle(it.id) }
        return binding.root
    }

    fun goToRegistrarCliente(){
        findNavController().navigate(R.id.action_listaClientesView_to_ABMCliente)
    }

    fun goToClienteDetalle(id: Int){
        Log.d("Main", "Se carga el id: $id")
        viewModel._idClienteActual.value = id
        val bundle = bundleOf("clienteId" to viewModel._idClienteActual.value)
        findNavController().navigate(R.id.action_listaClientesView_to_fragmentContainerCliente, bundle)
    }

    private fun showToast(msg: String?){
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

}