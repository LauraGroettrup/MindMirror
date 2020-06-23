package com.fh.joanneum.mindmirror

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.registration.*
import java.lang.Exception

class Registration : AppCompatActivity() {

    var usersReference: CollectionReference = FirebaseFirestore.getInstance().collection("users")
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        btnRegister.setOnClickListener {
            checkForm()
        }
    }

    private fun checkForm() {
        if (editEnterUsername.text.toString().equals("") || editEnterEmail.text.equals("") ||
            editRepeatPasswort.text.equals("") || editEnterPasswort.text.equals("")
        ) {
            Log.e("Error", "Please fill out all fields")
        } else {
            User.setUsername(editEnterUsername.text.toString())
            registerUser()
        }
    }

    private fun registerUser() {
        auth = Firebase.auth
        auth.createUserWithEmailAndPassword(
            editEnterEmail.text.toString(),
            editEnterPasswort.text.toString()
        ).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                goToLogin(auth.currentUser)
            } else {
                Toast.makeText(
                    baseContext, "Registration failed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun goToLogin(currentUser: FirebaseUser?) {
        var userToSave: HashMap<String, Any> = HashMap<String, Any>()
        var userReference: DocumentReference = usersReference.document(currentUser!!.uid)
        userToSave.put("username", editEnterUsername.text.toString())
        userToSave.put("email", editEnterEmail.text.toString())
        userToSave.put("password", editEnterPasswort.text.toString())
        userReference.set(userToSave).addOnSuccessListener {
            Log.d("DATABASE", "Saved the user in DB under " + currentUser!!.uid)
            val intent = Intent(this, RegistrationConfirmation::class.java)
            startActivity(intent)
        }.addOnFailureListener{ exception: Exception -> Log.e("LOGIN", exception.toString()) }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }


}