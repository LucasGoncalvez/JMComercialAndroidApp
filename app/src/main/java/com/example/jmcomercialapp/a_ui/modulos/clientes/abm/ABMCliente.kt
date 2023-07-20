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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.lista_clientes_fragment)
        binding = FragmentAbmClienteBinding.inflate(inflater, container, false)
        binding.abmcliente = this@ABMCliente
        binding.viewModelUtils = viewModelUtils
        binding.lifecycleOwner = viewLifecycleOwner
        viewModelUtils.getCities()
        return binding.root
    }

    fun btnCiudadAction(){
        var selectedItem = -1 //Posición seleccionada (-1 indica que ninguna de las opciones estará seleccionada)
        val listCities: Array<String> = viewModelUtils.listCities.value!!.map { it.denominacion }.toTypedArray()
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.caption_select_city_popup))
            .setPositiveButton(getString(R.string.btn_aceptar)){ _, _ ->
                if(listCities.isNotEmpty() && selectedItem > -1){
                    viewModelUtils.selectedCity.value = viewModelUtils.listCities.value!![selectedItem]
                } else {
                    viewModelUtils.initCity()
                }
            }
            .setNegativeButton(getString(R.string.btn_cancelar)){ dialog, _ ->
                dialog.dismiss()
            }
            .setSingleChoiceItems(listCities, selectedItem) { _, which ->
                selectedItem = which
            }
            .show()
    }

    fun btnAddGeolocationAction(){
        //showToast("Próximamente...")
        showToast(viewModelUtils.status.value!!)
    }

    private fun showToast(msg: String){
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    fun getCityName(): String{
        if(viewModelUtils.selectedCity.value != null){
            return viewModelUtils.selectedCity.value!!.denominacion
        }
        else{
            return getString(R.string.caption_selected_empty)
        }
    }
}