package com.fh.joanneum.mindmirror

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.model.User
import kotlinx.android.synthetic.main.registration_confirmation.*

class RegistrationConfirmation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_confirmation)


        lblEmail.setText(getString(R.string.welcome, User.getUsername()))

        btnToLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}