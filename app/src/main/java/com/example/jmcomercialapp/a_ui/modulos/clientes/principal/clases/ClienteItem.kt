package com.example.jmcomercialapp.a_ui.modulos.clientes.principal.clases

//Objeto para el item del RecyclerView de la lista principal de clientes
data class ClienteItem(
    val nombre: String,
    val apellido: String,
    val ciudad: String
)

class ListaClientesDataSource(){
    //Carga datos de prueba para mostrar en el RecyclerView
    fun loadData(): List<ClienteItem>{
        return listOf(
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá"),
            ClienteItem("Lucas", "Goncalvez", "Areguá")
        )
    }
}