package com.example.jmcomercialapp.b_viewmodel.menu

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jmcomercialapp.a_ui.menu.principal.MenuPrincipalAdapter
import com.example.jmcomercialapp.c_data.menu.clases.MenuPrincipalItem

@BindingAdapter("listDataMenuPrincipal")
fun bindListDataMenuPrincipal(recyclerView: RecyclerView, data: List<MenuPrincipalItem>){
    val adapter = recyclerView.adapter as MenuPrincipalAdapter
    adapter.submitList(data)
}