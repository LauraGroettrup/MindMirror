package com.fh.joanneum.mindmirror.analysis

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.PathSelection
import com.fh.joanneum.mindmirror.R
import kotlinx.android.synthetic.main.early_end.*

class EarlyEnd : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.early_end)

        btnBackToMain.setOnClickListener {
            val intent = Intent(this, PathSelection::class.java)
            startActivity(intent)
        }
    }
}