package com.example.jmcomercialapp.a_ui.modulos.clientes.abm

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.PopupWindow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jmcomercialapp.R
import com.example.jmcomercialapp.databinding.FragmentAbmClienteBinding

class ABMCliente : Fragment() {

    private lateinit var binding: FragmentAbmClienteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.lista_clientes_fragment)
        binding = FragmentAbmClienteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //(activity as AppCompatActivity).supportActionBar?.title = getString(R.string.lista_clientes_fragment)
    }

    fun btnCiudadAction(){
        val inflater = LayoutInflater.from(requireContext())
        val popupView = inflater.inflate(R.layout.popup_cities, null)

        val popupWindow = PopupWindow(
            popupView,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )

        popupWindow.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        popupWindow.showAtLocation(binding.btnSelectCity, Gravity.CENTER, 0, 0)

        popupWindow.setOnDismissListener {
            //TODO: Perform any actions upon dismissal of the popup window
        }

        val closeButton = popupView.findViewById<Button>(R.id.cancelSelectCityButton)
        closeButton.setOnClickListener{
            popupWindow.dismiss()
        }
    }

    fun btnAddGeolocationAction(){
        showToast("Próximamente...")
    }

    private fun showToast(msg: String){
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

}