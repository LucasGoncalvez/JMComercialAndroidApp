package com.example.jmcomercialapp.c_data.modulos.clientes.network

import com.example.jmcomercialapp.d_utils.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
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
}

object ClienteApi{
    val retrofitService: ClienteApiService by lazy {
        retrofit.create(ClienteApiService::class.java)
    }

    val retrofitServiceAux: ClienteApiService by lazy {
        retrofitAux.create(ClienteApiService::class.java)
    }
}