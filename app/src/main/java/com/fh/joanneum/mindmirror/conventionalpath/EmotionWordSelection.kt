package com.fh.joanneum.mindmirror.conventionalpath

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.fh.joanneum.mindmirror.MainActivity
import com.fh.joanneum.mindmirror.R
import com.fh.joanneum.mindmirror.analysis.SituationAnalysis
import com.fh.joanneum.mindmirror.model.ConventionalSession
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.word_emotion.view.*
import kotlinx.android.synthetic.main.word_selection.*


class EmotionWordSelection : AppCompatActivity() {

    var adapter: EmotionWordAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_selection)

        adapter =
            EmotionWordAdapter(this)
        gridWordEmotions.adapter = adapter

        gridWordEmotions.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                var emotion = parent.getItemAtPosition(position) as String
                var textView = view.lblEmotion

                ConventionalSession.setEmotions(emotion)
                if(ConventionalSession.getEmotions().contains(emotion)){
                    textView.setTextColor(Color.BLACK)
                }
                else{
                    textView.setTextColor(Color.GRAY)
                }
            }

        btnSubmit.setOnClickListener {
            val intent = Intent(this, SituationAnalysis::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.actionLogout -> {
                Firebase.auth.signOut()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}