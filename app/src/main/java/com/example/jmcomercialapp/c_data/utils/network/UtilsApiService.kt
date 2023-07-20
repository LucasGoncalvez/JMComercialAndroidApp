package com.example.jmcomercialapp.c_data.utils.network

import com.example.jmcomercialapp.c_data.utils.clases.Ciudad
import com.example.jmcomercialapp.d_utils.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface UtilsApiService{
    @GET("api/Ubicacion/GetCiudades")
    suspend fun getCities(): Array<Ciudad>
}

object UtilsApi{
    val retrofitService: UtilsApiService by lazy {
        retrofit.create(UtilsApiService::class.java)
    }
}