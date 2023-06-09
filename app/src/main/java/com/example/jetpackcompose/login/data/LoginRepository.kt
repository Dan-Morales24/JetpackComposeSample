package com.example.jetpackcompose.login.data

import com.example.jetpackcompose.login.data.network.LoginService
import javax.inject.Inject

/**Se prepara el LoginRepository con arroba Inject para ser inyectado donde sea necesario, el constructor es para saber que se esta inyectando en la clase**/
class LoginRepository @Inject constructor(private val api:LoginService) {
    //private val api = LoginService()

    suspend fun doLogin(user:String, password:String):Boolean{

        return api.doLogin(user, password)
    }
}