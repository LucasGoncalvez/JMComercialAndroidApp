package com.example.jmcomercialapp.c_data.menu.clases

import com.example.jmcomercialapp.R

class MenuPrincipalDataSource {
    fun loadItems(): List<MenuPrincipalItem>{
        return listOf(
            MenuPrincipalItem(10, "Tarjetas de articulos", R.drawable.male_clothes),
            MenuPrincipalItem(20, "Tarjetas de prestamos", R.drawable.personal),
            MenuPrincipalItem(30, "Inventario", R.drawable.stocks),
            MenuPrincipalItem(40, "Clientes", R.drawable.customer),
            MenuPrincipalItem(50, "Seguridad", R.drawable.settings)
        )
    }
}