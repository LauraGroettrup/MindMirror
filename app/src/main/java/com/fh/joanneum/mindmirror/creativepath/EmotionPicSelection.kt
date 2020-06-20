package com.fh.joanneum.mindmirror.creativepath

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.R
import kotlinx.android.synthetic.main.creative_start.*
import kotlinx.android.synthetic.main.picture_selection.*

class EmotionPicSelection : AppCompatActivity() {

    var adapter: EmotionPicAdapter? = null

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
                val intent = Intent(this, PictureExpression::class.java)
                startActivity(intent)
            }

        btnAddPic.setOnClickListener {
            //if necessary, implement logic for fileupload here
        }
    }
}