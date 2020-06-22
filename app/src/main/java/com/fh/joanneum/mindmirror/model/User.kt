package com.fh.joanneum.mindmirror.model

import android.util.Log

object User {
    private var username: String = ""
    private var password: String = ""
    private var email: String = ""

    fun getUsername():String{
        Log.d("USER","return name" + username)
        return username
    }
    fun setUsername(username_:String){
        Log.d("USER","Set username with" + username_)
        this.username = username_
    }

    fun getPassword():String{
        return password
    }
    fun setPassword(password:String){
        this.password = password
    }

    fun getEmail():String{
        return email
    }
    fun setEmail(email:String){
        this.email = email
    }
}


