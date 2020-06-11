package com.fh.joanneum.mindmirror.creativepath

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.R
import kotlinx.android.synthetic.main.picture_expression.*

class PictureExpression : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.picture_expression)
        iVselectedPicture.setImageResource(CreativeSession.getPicture())

        btnContinue.setOnClickListener {
            val intent = Intent(this, SituationAnalysis::class.java)
            startActivity(intent)
        }
    }
}