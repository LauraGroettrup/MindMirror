package com.fh.joanneum.mindmirror.creativepath

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.R
import com.fh.joanneum.mindmirror.analysis.SituationAnalysis
import kotlinx.android.synthetic.main.picture_expression.*

class PictureExpression : AppCompatActivity() {

    lateinit var inputField: EditText
    lateinit var answer2: String
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.picture_expression)

        iVselectedPicture.setImageResource(CreativeSession.getPicture())

        inputField = findViewById(R.id.eTPicExpressionMood)
        button = findViewById(R.id.btnContinue )

        button.setOnClickListener {
            answer2 = inputField.text.toString()

            //save data to model
            CreativeSession.setAnswer2(answer2)

            val intent = Intent(this, SituationAnalysis::class.java)
            startActivity(intent)
        }
    }
}