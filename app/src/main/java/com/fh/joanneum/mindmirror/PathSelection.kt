package com.fh.joanneum.mindmirror

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fh.joanneum.mindmirror.conventionalpath.ConventionalStart
import com.fh.joanneum.mindmirror.creativepath.CreativeStart
import com.fh.joanneum.mindmirror.model.Analysis
import com.fh.joanneum.mindmirror.model.ConventionalSession
import com.fh.joanneum.mindmirror.model.User
import kotlinx.android.synthetic.main.path_selection.*
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.fh.joanneum.mindmirror.model.CreativeSession
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class PathSelection : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.path_selection)
        lblHello.setText(getString(R.string.hello, User.getUsername()))
        cleanSessions()
        btnConventionel.setOnClickListener {
            val intent = Intent(this, ConventionalStart::class.java)
            startActivity(intent)
        }

        btnCreative.setOnClickListener {
            val intent = Intent(this, CreativeStart::class.java)
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

    private fun cleanSessions() {
        ConventionalSession.clear()
        CreativeSession.clear()
        Analysis.clear()
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
