package com.example.ai37a.repo

import com.example.ai37a.model.UserModel
import com.google.firebase.auth.FirebaseUser
import javax.security.auth.callback.Callback

interface UserRepo {

    fun login(email:String,password:String,callback:(Boolean,String) -> Unit )

    fun forgetPassword(email:String,callback: (Boolean, String) -> Unit)

    fun updateProfile(userId: String,model: UserModel,callback: (Boolean, String) -> Unit)

    fun deleteAccount(userId: String,callback: (Boolean, String) -> Unit)

    fun getCurrentUser(): FirebaseUser?

    fun logOut(callback: (Boolean, String) -> Unit)

    fun getUserById(userId:String,callback: (Boolean, String, UserModel?) -> Unit)

    fun getAllUser(callback: (Boolean, String,List<UserModel>?) -> Unit)

    fun register(email: String,password: String,callback: (Boolean, String, String) -> Unit)

    fun addUserToDatabase(
        userId:String,
        model: UserModel,
        callback: (Boolean, String) -> Unit
    )
}