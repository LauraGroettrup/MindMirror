package com.fh.joanneum.mindmirror.model


object User {
    private var username: String = ""
    private var password: String = ""
    private var email: String = ""

    fun getUsername(): String {
        return username
    }

    fun setUsername(username_: String) {
        this.username = username_
    }

    fun getPassword(): String {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun getEmail(): String {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }
}


