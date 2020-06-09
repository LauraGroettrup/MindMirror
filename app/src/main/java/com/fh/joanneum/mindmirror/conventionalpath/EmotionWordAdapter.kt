package com.fh.joanneum.mindmirror.conventionalpath

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.fh.joanneum.mindmirror.R
import kotlinx.android.synthetic.main.word_emotion.view.*


class EmotionWordAdapter : BaseAdapter {
    val emotions = arrayOf(
        "gelassen",
        "froh",
        "begeistert",
        "akzeptierend",
        "vertraut",
        "bewundernd",
        "besorgt",
        "ängstlich",
        "erschrocken",
        "verwirrt",
        "überrascht",
        "erstaunt",
        "nachdenklich",
        "traurig",
        "betrübt",
        "gelangweilt",
        "ablehnend",
        "angewidert",
        "gereizt",
        "verärgert",
        "wütend",
        "neugierig",
        "bereit",
        "achtsam"
    )
    var context: Context? = null

    constructor(context: Context) : super() {
        this.context = context
    }

    override fun getCount(): Int {
        return emotions.size
    }

    override fun getItem(position: Int): Any {
        return emotions[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val emotionString = this.emotions[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var emotionView = inflator.inflate(R.layout.word_emotion, null)
        emotionView.lblEmotion.text = emotionString

        return emotionView
    }
}
