package com.fh.joanneum.mindmirror

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.registration.*

class Registration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        //Initialise User
        User.setUsername("")
        User.setEmail("")
        User.setPassword("")
        User.setNickname("")

        editUsername

        btnRegister.setOnClickListener {
            val intent = Intent(this, RegistrationConfirmation::class.java)
            startActivity(intent)
        }
    }
}