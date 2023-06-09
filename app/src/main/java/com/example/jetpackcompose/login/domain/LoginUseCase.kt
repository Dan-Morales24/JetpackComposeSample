package com.example.jetpackcompose.login.domain

import com.example.jetpackcompose.login.data.LoginRepository
import javax.inject.Inject

/**Se prepara el LoginUseCase con arroba Inject para ser inyectado donde sea necesario, el constructor es para saber que se esta inyectando en la clase**/
class LoginUseCase @Inject constructor(val repository: LoginRepository) {
  //  val repository = LoginRepository()

    suspend operator fun invoke(user:String, password:String):Boolean{
       return repository.doLogin(user,password)
    }
}