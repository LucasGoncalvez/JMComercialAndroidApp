package com.example.jmcomercialapp.a_ui.modulos.clientes.viewdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.jmcomercialapp.R
import com.example.jmcomercialapp.a_ui.modulos.clientes.viewdetail.clases.TabPageAdapterCliente
import com.example.jmcomercialapp.databinding.FragmentContainerClienteBinding
import com.google.android.material.tabs.TabLayout

class FragmentContainerCliente : Fragment() {

    private lateinit var binding: FragmentContainerClienteBinding
    private lateinit var viewPagerAdapter: TabPageAdapterCliente

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.lista_clientes_fragment)
        binding = FragmentContainerClienteBinding.inflate(inflater, container, false)
        val tabCount = binding.tabLayoutCliente.tabCount
        viewPagerAdapter = TabPageAdapterCliente(this@FragmentContainerCliente, tabCount)
        binding.viewPagerCliente.adapter = viewPagerAdapter
        binding.viewPagerCliente.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    binding.tabLayoutCliente.selectTab(binding.tabLayoutCliente.getTabAt(position))
                }
            }
        )
        binding.tabLayoutCliente.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    binding.viewPagerCliente.currentItem = tab!!.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    //Acción cuando se deselecciona una pestaña
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    //Acción cuando se vuelve a seleccionar una pestaña
                }

            }
        )
        return binding.root
    }

}