package com.example.jetpackcompose.login.data.network

import com.example.jetpackcompose.login.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class  LoginService @Inject constructor(private val loginClient: LoginClient) {
    //private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(user:String, password:String):Boolean{
      return   withContext(Dispatchers.IO){
          val response = loginClient.doLogin()
          /** Ejemplo en el que le pasaria los parametros user y password a la interfaz de retrofit**/
//           val response = retrofit.create(LoginClient::class.java).doLogin(user, password)
          response.body()?.success?:false
        }

    }
}