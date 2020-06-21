package com.fh.joanneum.mindmirror

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.registration.*

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
                goToLogin()
            } else {
                Toast.makeText(
                    baseContext, "Registration failed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun goToLogin() {

        var dataToSave: HashMap<String, Any> = HashMap<String, Any>()
        var userReference: DocumentReference = usersReference.document("user1")
        dataToSave.put("username", editEnterUsername.text.toString())
        dataToSave.put("email", editEnterEmail.text.toString())
        dataToSave.put("password", editEnterPasswort.text.toString())
        userReference.set(dataToSave).addOnSuccessListener {
            Log.d("DATABASE", "Logged the user")
            val intent = Intent(this, RegistrationConfirmation::class.java)
            startActivity(intent)
        }
        val intent = Intent(this, RegistrationConfirmation::class.java)
        startActivity(intent)
    }


}