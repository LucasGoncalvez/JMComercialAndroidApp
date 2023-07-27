package com.example.jmcomercialapp.a_ui.modulos.clientes.abm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.jmcomercialapp.R
import com.example.jmcomercialapp.b_viewmodel.modulos.clientes.ClienteViewModel
import com.example.jmcomercialapp.b_viewmodel.utils.UtilsViewModel
import com.example.jmcomercialapp.d_utils.LOG_TAG
import com.example.jmcomercialapp.d_utils.MainStatuses
import com.example.jmcomercialapp.databinding.FragmentUpdateClienteBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class UpdateCliente : Fragment() {

    private lateinit var binding: FragmentUpdateClienteBinding
    private val viewModel: ClienteViewModel by activityViewModels()
    private val viewModelUtils: UtilsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelUtils.getDocTypes()
        viewModelUtils.getCities()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateClienteBinding.inflate(inflater, container, false)
        Log.d(LOG_TAG, "Id en UpdateCliente: ${viewModel.cliente.value?.id}")
        binding.updatecliente = this@UpdateCliente
        binding.viewModelUtils = viewModelUtils
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    fun btnTipoDoc(){
        var selectedItem =
            -1 //Posición seleccionada (-1 indica que ninguna de las opciones estará seleccionada)
        val listDocType: Array<String> =
            viewModelUtils.listDocTypes.value!!.map { it.denominacion }.toTypedArray()
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.caption_select_doc_popup))
            .setPositiveButton(getString(R.string.btn_aceptar)) { _, _ ->
                if (listDocType.isNotEmpty() && selectedItem > -1) {
                    viewModelUtils.selectedDocType.value =
                        viewModelUtils.listDocTypes.value!![selectedItem] //Al ordenar, el id ya no será selectedItem
                } else {
                    viewModelUtils.initDocType()
                }
            }
            .setNegativeButton(getString(R.string.btn_cancelar)) { dialog, _ ->
                dialog.dismiss()
            }
            .setSingleChoiceItems(listDocType, selectedItem) { _, which ->
                selectedItem = which
            }
            .show()
    }

    fun btnCiudad(){
        var selectedItem =
            -1 //Posición seleccionada (-1 indica que ninguna de las opciones estará seleccionada)
        val listCities: Array<String> =
            viewModelUtils.listCities.value!!.map { it.denominacion }.toTypedArray()
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.caption_select_city_popup))
            .setPositiveButton(getString(R.string.btn_aceptar)) { _, _ ->
                if (listCities.isNotEmpty() && selectedItem > -1) {
                    viewModelUtils.selectedCity.value =
                        viewModelUtils.listCities.value!![selectedItem] //Al ordenar, el id ya no será selectedItem
                } else {
                    viewModelUtils.initCity()
                }
            }
            .setNegativeButton(getString(R.string.btn_cancelar)) { dialog, _ ->
                dialog.dismiss()
            }
            .setSingleChoiceItems(listCities, selectedItem) { _, which ->
                selectedItem = which
            }
            .show()
    }

    fun btnAddGeolocationAction(){
        showToast("Próximamente...")
    }

    fun cancelar(){
        if(viewModel.statusAction.value != MainStatuses.DONE){
            MaterialAlertDialogBuilder(requireContext())
                .setMessage(getString(R.string.message_cancel_abm))
                .setPositiveButton(getString(R.string.btn_stay_here)) { _, _ ->
                    //Sin acción para quedarme en la misma pantalla
                }
                .setNegativeButton(getString(R.string.btn_discard)) { _, _ ->
                    findNavController().navigate(R.id.action_updateCliente_to_fragmentContainerCliente, bundleOf("clienteId" to viewModel.cliente.value?.id))
                }
                .show()
        } else{
            findNavController().navigate(R.id.action_updateCliente_to_fragmentContainerCliente, bundleOf("clienteId" to viewModel.cliente.value?.id))
        }
    }

    fun updateCliente(){

    }

    private fun showToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    cancelar()
                }
            })
    }
}