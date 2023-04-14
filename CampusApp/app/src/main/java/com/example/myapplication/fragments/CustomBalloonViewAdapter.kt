package com.example.myapplication.fragments

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.classes.Markers
import com.tomtom.sdk.map.display.marker.BalloonViewAdapter
import com.tomtom.sdk.map.display.marker.Marker

class CustomBalloonViewAdapter(private val context: Context) : BalloonViewAdapter {

    override fun onCreateBalloonView(marker: Marker): View {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_balloon_view, null)
        var m = Markers()
        var am = m.getActiveMarker(marker.tag.toString())
        var image = view.findViewById<ImageView>(R.id.ballon_image)
        image.setImageResource(am.pinImage.hashCode())
        var typeBuilding = view.findViewById<TextView>(R.id.building_type)
        if(am.pinImage.hashCode()==R.drawable.uni){
            typeBuilding.text = "Department"
        }
        if(am.pinImage.hashCode()==R.drawable.house){
            typeBuilding.text = "Residence"
        }
        if(am.pinImage.hashCode()==R.drawable.sports){
            typeBuilding.text = "Sports Facility"
        }
        if(am.pinImage.hashCode()==R.drawable.canteen){
            typeBuilding.text = "Canteen"
        }
        if(am.pinImage.hashCode()==R.drawable.friends){
            typeBuilding.text = "Leisure Place"
        }



        var balloonTextTv = view.findViewById<TextView>(R.id.balloon_text_tv)
        balloonTextTv.text = marker.tag
        return view
    }



}