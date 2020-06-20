package com.fh.joanneum.mindmirror

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.login.*

@Suppress("UNREACHABLE_CODE")
class Login : AppCompatActivity() {

    var email: EditText? = null
    var password: EditText? = null
    //private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        email = findViewById(R.id.editEmail)
        password = findViewById(R.id.editPassword)

        /*
        // Initialize Firebase Auth
        auth = Firebase.auth

        fun login() {
            val intent = Intent(this, PathSelection::class.java)
            startActivity(intent)
        }

        if (auth.currentUser != null) {
            login()
        }
         */

        btnLogin.setOnClickListener{
            /*
            auth.signInWithEmailAndPassword(email?.text.toString(), password?.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        login()
                    } else {
                        auth.createUserWithEmailAndPassword(
                            email?.text.toString(),
                            password?.text.toString()
                        )
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {
                                    login()
                                } else {
                                    Toast.makeText(
                                        baseContext, "Authentication failed.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }

                    }
                }
             */
            btnLogin.setOnClickListener {
                val intent = Intent(this, PathSelection::class.java)
                startActivity(intent)
            }
        }
    }


}