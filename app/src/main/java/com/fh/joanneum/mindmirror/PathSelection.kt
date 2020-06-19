package com.fh.joanneum.mindmirror

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fh.joanneum.mindmirror.conventionalpath.ConventionalStart
import com.fh.joanneum.mindmirror.creativepath.CreativeStart
import kotlinx.android.synthetic.main.path_selection.*

class PathSelection : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.path_selection)

        lblHello.setText(getString(R.string.hello, User.getNickname()))

        btnConventionel.setOnClickListener {
            val intent = Intent(this, ConventionalStart::class.java)
            startActivity(intent)
        }

        btnCreative.setOnClickListener {
            val intent = Intent(this, CreativeStart::class.java)
            startActivity(intent)
        }
    }
}
