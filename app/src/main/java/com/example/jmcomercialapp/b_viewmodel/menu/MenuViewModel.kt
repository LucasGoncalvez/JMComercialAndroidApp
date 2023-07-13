package com.example.jmcomercialapp.b_viewmodel.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jmcomercialapp.R
import com.example.jmcomercialapp.c_data.menu.clases.MenuPrincipalDataSource
import com.example.jmcomercialapp.c_data.menu.clases.MenuPrincipalItem

class MenuViewModel: ViewModel() {

    private val _listItems = MutableLiveData<List<MenuPrincipalItem>>()
    val listItems: LiveData<List<MenuPrincipalItem>>
        get() = _listItems

    private val _saludo = MutableLiveData<String>()
    val saludo: LiveData<String>
        get() = _saludo

    init {
        _listItems.value = MenuPrincipalDataSource().loadItems()
    }

    fun setGreeting(saludo: String){
        _saludo.value = saludo
    }
}