package com.example.jmcomercialapp.c_data.modulos.clientes.network

import com.example.jmcomercialapp.c_data.modulos.clientes.clases.cliente.Cliente
import com.example.jmcomercialapp.c_data.modulos.clientes.clases.cliente.ClienteDetail
import com.example.jmcomercialapp.c_data.modulos.clientes.clases.cliente.ClientePreviewData
import com.example.jmcomercialapp.c_data.modulos.clientes.clases.clientecontacto.ClienteContactoDetail
import com.example.jmcomercialapp.d_utils.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

private val retrofitAux = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ClienteApiService{
    @GET("api/Persona/GetAll")
    suspend fun getClientesPreview(): MutableList<ClientePreviewData>

    @GET("api/Persona/Get?")
    suspend fun getClienteDetail(@Query("id") id: Int): ClienteDetail

    @GET("api/Persona/GetContacts?")
    suspend fun getClienteContactos(@Query("personaId") id: Int): MutableList<ClienteContactoDetail>

    @POST("api/Persona/Add")
    suspend fun addCliente(@Body cliente: Cliente): Int

    @POST("api/Persona/Update")
    suspend fun updateCliente(@Body cliente: Cliente): Int

}

object ClienteApi{
    val retrofitService: ClienteApiService by lazy {
        retrofit.create(ClienteApiService::class.java)
    }

    val retrofitServiceAux: ClienteApiService by lazy {
        retrofitAux.create(ClienteApiService::class.java)
    }
}