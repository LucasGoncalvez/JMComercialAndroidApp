package com.example.jmcomercialapp.a_ui.modulos.clientes.abm

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.jmcomercialapp.R
import com.example.jmcomercialapp.b_viewmodel.login.LoginViewModel
import com.example.jmcomercialapp.b_viewmodel.utils.UtilsViewModel
import com.example.jmcomercialapp.c_data.modulos.clientes.clases.cliente.Cliente
import com.example.jmcomercialapp.databinding.FragmentAbmClienteBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.time.LocalDateTime

class ABMCliente : Fragment() {

    private lateinit var binding: FragmentAbmClienteBinding
    private val viewModelUtils: UtilsViewModel by viewModels()
    private val viewModelLogin: LoginViewModel by activityViewModels()
    lateinit var cliente: Cliente

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.lista_clientes_fragment)
        binding = FragmentAbmClienteBinding.inflate(inflater, container, false)
        binding.abmcliente = this@ABMCliente
        binding.viewModelUtils = viewModelUtils
        binding.lifecycleOwner = viewLifecycleOwner
        viewModelUtils.getCities()
        return binding.root
    }

    fun btnCiudadAction() {
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

    fun btnAddGeolocationAction() {
        showToast("Próximamente...")
    }

    private fun showToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    fun registrarCliente() {
        if (!validarCampos()) return
        binding.apply {
            cliente = Cliente(
                id = 0,
                nombre = inputNombreValue.text.toString(),
                apellido = inputApellidoValue.text.toString().trim().ifEmpty { null },
                tipoDocumentoId = null,
                numeroDocumento = null,
                paisId = viewModelUtils?.selectedCity?.value!!.paisId,
                departamentoId = viewModelUtils?.selectedCity?.value!!.departamentoId,
                ciudadId = viewModelUtils?.selectedCity?.value!!.id,
                zonaBarrioId = null,
                direccion = inputDireccionValue.text.toString().trim().ifEmpty { null },
                geolocalizacion = null,
                loginIdAlta = if (viewModelLogin.currentUser.value != null) viewModelLogin.currentUser.value!!.id else null,
                fechaAlta = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) LocalDateTime.now() else null, //TODO Verificar como recuperar la fecha y hora para versiones inferiores
                loginIdUltMod = null,
                fechaUltMod = null,
                habilitado = true
            )
        }
        Log.d("Main", "Datos del cliente: $cliente")
    }

    fun validarCampos(): Boolean {
            if(binding.inputNombreValue.text.toString().trim().isEmpty()){
                setErrorTextField(true)
                return false
            } else{
                setErrorTextField(false)
            }
            if (viewModelUtils.selectedCity.value!!.id == -1){
                showToast(getString(R.string.city_required))
                return false
            }

        return true
    }

    fun setErrorTextField(error: Boolean) {
        if (error) {
            binding.inputNombre.error = getString(R.string.data_required)
            binding.inputNombre.isErrorEnabled = true
        } else {
            binding.inputNombre.error = null
            binding.inputNombre.isErrorEnabled = false
        }
    }

    fun cancelar() {
        MaterialAlertDialogBuilder(requireContext())
            .setMessage(getString(R.string.message_cancel_abm))
            .setPositiveButton(getString(R.string.btn_save)) { _, _ ->
                showToast("Guardar cliente")
            }
            .setNegativeButton(getString(R.string.btn_discard)) { _, _ ->
                findNavController().navigate(R.id.action_ABMCliente_to_listaClientesView)
            }
            .show()
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