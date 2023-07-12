package com.example.jmcomercialapp.b_viewmodel.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jmcomercialapp.c_data.menu.clases.MenuPrincipalDataSource
import com.example.jmcomercialapp.c_data.menu.clases.MenuPrincipalItem

class MenuViewModel: ViewModel() {

    private val _listItems = MutableLiveData<List<MenuPrincipalItem>>()
    val listItems: LiveData<List<MenuPrincipalItem>>
        get() = _listItems

    init {
        _listItems.value = MenuPrincipalDataSource().loadItems()
    }
}