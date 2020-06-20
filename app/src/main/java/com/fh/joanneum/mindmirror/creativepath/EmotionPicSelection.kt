package com.fh.joanneum.mindmirror.creativepath

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.R
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.picture_selection.*

class EmotionPicSelection : AppCompatActivity() {

    var adapter: EmotionPicAdapter? = null
    var docRef: DocumentReference = FirebaseFirestore.getInstance().document("data/creativeSession")
    var picMap:  MutableMap<String, Int> = mutableMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.picture_selection)

        adapter = EmotionPicAdapter(this)
        gridPicEmotions.adapter = adapter

        gridPicEmotions.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                CreativeSession.setPicture(parent.getItemAtPosition(position).toString().toInt())
                Toast.makeText(
                    this@EmotionPicSelection,
                    " Clicked Emotion: " + parent.getItemAtPosition(position).toString(),
                    Toast.LENGTH_SHORT
                ).show()
                saveSelectedPic()
                val intent = Intent(this, PictureExpression::class.java)
                startActivity(intent)
            }


    }
    fun saveSelectedPic(){
        var selectedPic = CreativeSession.getPicture()
        picMap.put("selected Pic", selectedPic)
        docRef.set(picMap).addOnSuccessListener {
            Log.d("Selected Pic", "Pic hast been saved.")
        }.addOnFailureListener{
            Log.d("Selected Pic","Document was not saved")
        }
    }
}