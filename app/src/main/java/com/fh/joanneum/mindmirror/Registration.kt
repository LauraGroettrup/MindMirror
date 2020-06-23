package com.fh.joanneum.mindmirror

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
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
        val errorMsg = getResources().getString(R.string.registrationError)
        if (editEnterUsername.text.toString().equals("")) {
            lblRegistrationError.text =
                errorMsg + " Username darf nicht leer sein "
            lblRegistrationError.visibility= View.VISIBLE
        } else if (editEnterEmail.text.toString().equals("")) {
            lblRegistrationError.text =
                errorMsg + "Email darf nicht leer sein "
            lblRegistrationError.visibility= View.VISIBLE
        } else if (!Patterns.EMAIL_ADDRESS.matcher(editEnterEmail.text.toString()).matches()) {
            lblRegistrationError.text =
                errorMsg + "Email ist nicht gültig "
            lblRegistrationError.visibility= View.VISIBLE
        } else if (editEnterPasswort.text.toString().equals("")) {
            lblRegistrationError.text =
                errorMsg + "Passwort darf nicht leer sein "
            lblRegistrationError.visibility= View.VISIBLE
        } else if (!editEnterPasswort.text.toString().equals(editRepeatPasswort.text.toString())) {
            lblRegistrationError.text =
                errorMsg + "Nicht das gleiche Passwort"
            lblRegistrationError.visibility= View.VISIBLE
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

    private fun goToLogin(currentUser: FirebaseUser?) {
        var userToSave: HashMap<String, Any> = HashMap<String, Any>()
        var userReference: DocumentReference = usersReference.document(currentUser!!.uid)
        userToSave.put("username", editEnterUsername.text.toString())
        userToSave.put("email", editEnterEmail.text.toString())
        userToSave.put("password", editEnterPasswort.text.toString())
        userReference.set(userToSave).addOnSuccessListener {
            Log.d("DATABASE", "Saved the user in DB under " + currentUser!!.uid)
            val intent = Intent(this, RegistrationConfirmation::class.java)
            startActivity(intent)
        }.addOnFailureListener { exception: Exception -> Log.e("LOGIN", exception.toString()) }
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