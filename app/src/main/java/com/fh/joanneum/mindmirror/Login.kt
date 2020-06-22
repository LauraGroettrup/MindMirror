package com.fh.joanneum.mindmirror

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.login.*

@Suppress("UNREACHABLE_CODE")
class Login : AppCompatActivity() {

    var usersReference: CollectionReference = FirebaseFirestore.getInstance().collection("users")
    var email: EditText? = null
    var password: EditText? = null
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Auth
        auth = Firebase.auth


        if (auth.currentUser != null) {
            login()
        } else {
            setContentView(R.layout.login)
            email = findViewById(R.id.editEmail)
            password = findViewById(R.id.editPassword)
            btnLogin.setOnClickListener {
                auth.signInWithEmailAndPassword(email?.text.toString(), password?.text.toString())
                    .addOnSuccessListener { result ->
                        login()
                    }.addOnFailureListener { exception -> Log.e("LOGIN", exception.toString()) }
            }
        }
    }

    fun login() {
        var userReference: DocumentReference = usersReference.document(auth.currentUser!!.uid)
        userReference.get().addOnSuccessListener { document ->
            Log.d("Login", document.data?.get("username") as String)
            User.setUsername(document.data?.get("username") as String)
            User.setEmail(document.data?.get("email") as String)
            User.setPassword(document.data?.get("password") as String)
            val intent = Intent(this, PathSelection::class.java)
            startActivity(intent)
        }
    }
}