package com.fh.joanneum.mindmirror.creativepath

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.R
import kotlinx.android.synthetic.main.creative_start.*

class CreativeStart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creative_start)

        btnStart.setOnClickListener {
            val intent = Intent(this, EmotionPicSelection::class.java)
            startActivity(intent)
        }
    }
}