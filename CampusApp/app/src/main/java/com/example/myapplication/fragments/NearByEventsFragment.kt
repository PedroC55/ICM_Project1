package com.example.myapplication.fragments

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.text.Html
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TextView
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.classes.RecyclerViewAdapter
import com.example.myapplication.database.DatabaseInfo
import com.google.android.material.bottomnavigation.BottomNavigationView


class NearByEventsFragment : Fragment(R.layout.fragment_events) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation).visibility = View.GONE
        val rv : RecyclerView = requireActivity().findViewById(R.id.recyclerView)
        var rva = rv.adapter as RecyclerViewAdapter

        Log.d("SUI", rva.getitemid().toString())

        val db = DatabaseInfo(requireContext(), null)
        val e = db.getEventById(rva.getitemid())
        e.moveToFirst()

        val view = inflater.inflate(R.layout.fragment_events, container, false)

        val img = view.findViewById<ImageView>(R.id.imageView5)
        when (e.getString(6)){
            "Cinema" -> img.setImageResource(R.drawable.cinema)
            "Beach" -> img.setImageResource(R.drawable.praia)
            "Party" -> img.setImageResource(R.drawable.festa)
            "Sports" -> img.setImageResource(R.drawable.desporto1)
            "Game Night" -> img.setImageResource(R.drawable.gamenightlogocolor)
            "Concert" -> img.setImageResource(R.drawable.concerto)
        }
        val name = view.findViewById<TextView>(R.id.textView10)
        name.text = e.getString(1)
        val location = view.findViewById<TextView>(R.id.location)
        location.text = getString(R.string.location, e.getString(2))
        val np = view.findViewById<TextView>(R.id.number_people)
        np.text = getString(R.string.np, e.getString(4))
        val startTime = view.findViewById<TextView>(R.id.startTime)
        startTime.text = getString(R.string.Hours_Date, e.getString(3))
        val description = view.findViewById<TextView>(R.id.description)
        description.text = getString(R.string.description, e.getString(5))
        val creator = view.findViewById<TextView>(R.id.creator)
        val c = db.getUserById(e.getString(7).toInt())
        c.moveToFirst()
        creator.text = getString(R.string.creator, c.getString(1))
        creator.setOnClickListener{
            rva.setProfile(2)
            rva.setUserToSee(e.getString(7).toInt())
            findNavController().navigate(R.id.action_nearByEventsFragment_to_profileFragment)
        }
        return view

    }

    override fun onPause() {
        super.onPause()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation).visibility = View.VISIBLE
    }

}