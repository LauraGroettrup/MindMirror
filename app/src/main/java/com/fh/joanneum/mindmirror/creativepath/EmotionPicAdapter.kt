package com.fh.joanneum.mindmirror.creativepath

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.fh.joanneum.mindmirror.R
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.picture_emotion.view.*

class EmotionPicAdapter : BaseAdapter {
    var images: MutableList<StorageReference>
    var context: Context? = null

    constructor(context: Context, images: MutableList<StorageReference>) : super() {
        this.context = context
        this.images=images
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun getItem(position: Int): Any {
        return images[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val picUrl = this.images[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var emotionView = inflator.inflate(R.layout.picture_emotion, null)
        //emotionView.picEmotion.setImageResource(emotionInt!!)
        //emotionView.picEmotion.setImageURI(picUrl)
        Glide.with(this.context!!).load(picUrl).into(emotionView.picEmotion)

        return emotionView
    }



}