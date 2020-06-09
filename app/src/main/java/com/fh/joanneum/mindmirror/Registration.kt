package com.fh.joanneum.mindmirror

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.registration.*

class Registration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        btnRegister.setOnClickListener {
            val intent = Intent(this, RegistrationConfirmation::class.java)
            startActivity(intent)
        }
    }
}