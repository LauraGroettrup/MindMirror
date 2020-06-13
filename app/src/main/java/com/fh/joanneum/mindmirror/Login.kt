package com.fh.joanneum.mindmirror

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        btnLogin.setOnClickListener {
            var doesUserExist:Boolean = getUserFromDB()
            if (!doesUserExist) {
                val intent = Intent(this, PathSelection::class.java)
                startActivity(intent)
            }
            else{
                Log.e("Error", "User does not exist")
            }
        }
    }

    private fun getUserFromDB(): Boolean{
        if (editUsername.text.equals(User.getUsername())&&editPasswort.text.equals(User.getPassword())){
            return true
        }
        return false
    }
}