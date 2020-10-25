package com.example.loginwithviewpager.users

class UserService {
    companion object {
        private val users = arrayListOf<UserModel>()

        fun logIn(username: String, password: String): UserModel? {
            return users.find {
                it.username == username.toLowerCase().trim() && it.password == password
            }
        }


        fun register(username: String, password: String, confirmPassword: String) {

            if(username.isEmpty()){
                throw Exception("Preencha o campo username!")
            }

            if(password.isEmpty()){
                throw Exception("Preencha o campo password!")
            }

            if(password != confirmPassword){
                throw Exception("As senhas devem ser as iguais")
            }


            val user = users.find {
                it.username == username.toLowerCase().trim()
            }

            if (user != null) {
                throw Exception("Username já cadastrado!")
            }

            users.add(UserModel(username.toLowerCase().trim(), password))
        }

    }
}




