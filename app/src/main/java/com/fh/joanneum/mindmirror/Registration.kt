package com.fh.joanneum.mindmirror

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.registration.*

class Registration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        btnRegister.setOnClickListener {
            checkForm()
        }
    }

    private fun checkForm() {
        initialiseUser()
        if (User.getEmail().equals("") || User.getNickname().equals("") || User.getPassword()
                .equals("") || User.getUsername().equals("")
        ){
            Log.e("Error", "Please fill out all fields")
        }
        else {
            val intent = Intent(this, RegistrationConfirmation::class.java)
            startActivity(intent)
        }
    }

    private fun initialiseUser() {
        User.setUsername(editEnterUsername.text.toString())
        User.setEmail(editEnterEmail.text.toString())
        User.setPassword(editEnterPasswort.text.toString())
        User.setNickname(editEnterName.text.toString())
    }
}