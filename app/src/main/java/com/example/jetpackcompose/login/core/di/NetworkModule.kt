package com.example.jetpackcompose.login.core.di

import com.example.jetpackcompose.login.data.network.LoginClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/** Retrofit no puede ser inyectado de manera directa, tal cual como se hicieron en las
 * distintas clases ya que retrofit no fue preparado para ser inyectado, por lo cual se debe de
 * utilizar los Provider de Retrofit es una 4ta forma de Inject las dependencias.
 */


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    /** Con la notacion Provides, Dagger sabe si en algun momento pides Injectar retrofit, vendra y tomara
     * la funcion retrofitProvider :)
     */
    @Singleton
    @Provides
    fun retrofitProvider():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(retrofit: Retrofit): LoginClient {
        return retrofit.create(LoginClient::class.java)
    }

}