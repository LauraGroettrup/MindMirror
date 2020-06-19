package com.fh.joanneum.mindmirror.analysis

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.PathSelection
import com.fh.joanneum.mindmirror.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.early_end.*

class EarlyEnd : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.early_end)

        lblGoodbye.text= getString(R.string.goodbye, User.getNickname())

        btnBackToMain.setOnClickListener {
            val intent = Intent(this, PathSelection::class.java)
            startActivity(intent)
        }

        btnLogout.setOnClickListener{
            Firebase.auth.signOut()
            Toast.makeText(baseContext, "You are logged out.",
            Toast.LENGTH_SHORT
            ).show()
        }
    }
}