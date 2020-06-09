package com.fh.joanneum.mindmirror.conventionalpath

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.R
import kotlinx.android.synthetic.main.conventional_start.*

class ConventionalStart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.conventional_start)

        btnStart.setOnClickListener {
            val intent = Intent(this, EmotionWordSelection::class.java)
            startActivity(intent)
        }
    }
}