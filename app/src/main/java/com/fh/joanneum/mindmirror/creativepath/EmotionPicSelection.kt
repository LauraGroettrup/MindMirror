package com.fh.joanneum.mindmirror.creativepath

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage

import kotlinx.android.synthetic.main.picture_selection.*

class EmotionPicSelection : AppCompatActivity() {

    var adapter: EmotionPicAdapter? = null


    lateinit var storage: FirebaseStorage
    var imageUrlList = mutableListOf<StorageReference>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.picture_selection)
        getPicsFromFireStorage()
    }

    fun showUI() {
        adapter = EmotionPicAdapter(this, imageUrlList)
        gridPicEmotions.adapter = adapter

        gridPicEmotions.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                var pictureReference = parent.getItemAtPosition(position) as StorageReference
                CreativeSession.setPicture(pictureReference.name)
                Toast.makeText(
                    baseContext,
                    "Picture was saved as Uri to Model." + CreativeSession.getPicture().toString(),
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this, PictureExpression::class.java)
                startActivity(intent)
            }
    }

    fun getPicsFromFireStorage() {
        storage = Firebase.storage
        var storageRef = storage.reference
        var imagesRef: StorageReference? = storageRef.child("images")
        imagesRef?.listAll()?.addOnSuccessListener { images ->
            images.items.forEach { image ->
                Log.i("Download", image.name)
                imageUrlList.add(image)
                //image.downloadUrl.addOnSuccessListener { url -> imageUrlList.add(url) }
            }
            showUI()
        }?.addOnFailureListener {
            Log.e("Storage", it.toString())
        }
    }

}