package com.fh.joanneum.mindmirror

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.registration.*

class Registration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        editEnterName.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                checkForm()
                true
            } else {
                false
            }
        }

        btnRegister.setOnClickListener {
            checkForm()
        }
    }

    private fun checkForm() {
        initialiseUser()
        if (User.getEmail().equals("") || User.getNickname().equals("") || User.getPassword()
                .equals("") || User.getUsername().equals("")
        ){

        }

        val intent = Intent(this, RegistrationConfirmation::class.java)
        startActivity(intent)
    }

    private fun initialiseUser() {
        User.setUsername(editEnterUsername.text.toString())
        User.setEmail(editEnterEmail.text.toString())
        User.setPassword(editEnterPasswort.text.toString())
        User.setNickname(editEnterUsername.text.toString())
    }
}