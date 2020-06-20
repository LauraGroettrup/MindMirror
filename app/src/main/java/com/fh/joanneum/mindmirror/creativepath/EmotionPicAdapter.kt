package com.fh.joanneum.mindmirror.creativepath

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.fh.joanneum.mindmirror.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.picture_emotion.view.*

class EmotionPicAdapter : BaseAdapter {
    lateinit var storage: FirebaseStorage
    val emotions = intArrayOf(
        R.drawable.blur,
        R.drawable.calm,
        R.drawable.happy,
        R.drawable.dandelion,
        R.drawable.heart,
        R.drawable.quiet,
        R.drawable.sea,
        R.drawable.cat,
        R.drawable.adult,
        R.drawable.child,
        R.drawable.cloud,
        R.drawable.scream
    )
    var context: Context? = null

    constructor(context: Context) : super() {
        this.context = context
        getPicsFromFireStorage()
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
        val emotionInt = this.emotions[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var emotionView = inflator.inflate(R.layout.picture_emotion, null)
        emotionView.picEmotion.setImageResource(emotionInt!!)

        return emotionView
    }

    fun getPicsFromFireStorage() {
        storage = Firebase.storage
        var storageRef = storage.reference
        var imagesRef: StorageReference? = storageRef.child("images")
        if (imagesRef != null) {
            imagesRef.listAll().addOnSuccessListener { images ->
                images.items.forEach { image ->
                    Log.i(
                        "Storage",
                        image.toString()
                    )
                }
            }
        }
    }
}