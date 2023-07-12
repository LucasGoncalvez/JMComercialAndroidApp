package com.example.jmcomercialapp.c_data.menu.clases

import com.example.jmcomercialapp.R

class MenuPrincipalDataSource {
    fun loadItems(): List<MenuPrincipalItem>{
        return listOf(
            MenuPrincipalItem("Tarjetas de articulos", R.drawable.male_clothes),
            MenuPrincipalItem("Tarjetas de prestamos", R.drawable.personal),
            MenuPrincipalItem("Inventario", R.drawable.stocks),
            MenuPrincipalItem("Clientes", R.drawable.customer),
            MenuPrincipalItem("Seguridad", R.drawable.settings)
        )
    }
}