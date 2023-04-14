package com.example.myapplication.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.tomtom.sdk.map.display.marker.BalloonViewAdapter
import com.tomtom.sdk.map.display.marker.Marker

class CustomBalloonViewAdapter(private val context: Context) : BalloonViewAdapter {

    override fun onCreateBalloonView(marker: Marker): View {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_balloon_view, null)
        var image = view.findViewById<ImageView>(R.id.ballon_image)
        //image.setImageResource()
        val balloonTextTv = view.findViewById<TextView>(R.id.balloon_text_tv)
        balloonTextTv.text = marker.balloonText
        return view
    }
}