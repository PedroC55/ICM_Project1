package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView

import androidx.cardview.widget.CardView
import androidx.navigation.Navigation

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.classes.RecyclerViewAdapter
import com.example.myapplication.database.DatabaseInfo
import com.google.android.material.floatingactionbutton.FloatingActionButton


class DashboardFragment : Fragment(R.layout.fragment_dashboard) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        requireActivity().findViewById<RecyclerView>(R.id.recyclerView).visibility=View.VISIBLE
        requireActivity().findViewById<CardView>(R.id.cardView).visibility = View.VISIBLE
        val fab : FloatingActionButton = requireActivity().findViewById(R.id.fab)
        fab.visibility = View.VISIBLE
        fab.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_dashboardFragment_to_addEventFragment)
        }



        /*
        val button_profile: ImageButton = view.findViewById(R.id.profile_button)
        val button_where: ImageButton = view.findViewById(R.id.imageView7)
        val button_book_class: ImageButton = view.findViewById(R.id.imageView)
        val button_events: ImageButton = view.findViewById(R.id.imageView3)
        val button_campusmap: ImageButton = view.findViewById(R.id.imageView8)
        val button_courses: ImageButton = view.findViewById(R.id.imageView9)
        val button_schedule: ImageButton = view.findViewById(R.id.imageView10)
        val button_classroom_search: ImageButton = view.findViewById(R.id.imageView11)

        button_profile.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_dashboardFragment_to_profileFragment)}

        button_where.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_dashboardFragment_to_findCampusFragment)}

        button_book_class.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_dashboardFragment_to_classroomScheduleFragment)}

        button_events.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_dashboardFragment_to_nearByEventsFragment)}

        button_campusmap.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_dashboardFragment_to_mapFragment)}

        button_courses.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_dashboardFragment_to_coursesBeingTakenFragment)}

        button_schedule.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_dashboardFragment_to_scheduleFragment)}

        button_classroom_search.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_dashboardFragment_to_pathToClassroomFragment)}
        */

        return view
    }


    override fun onResume() {
        super.onResume()
        /*val db = DatabaseInfo(requireContext(), null)
        val c = db.getEvents()
        c.moveToFirst()
        val rva = RecyclerViewAdapter()
        while(c.moveToNext()){
            if(!rva.itemTitles.contains(c.getString(1))){
                rva.itemTitles= rva.itemTitles.plus(c.getString(1))
                rva.itemDescription=rva.itemDescription.plus(c.getString(5))
                when(tag){
                    "Beach" -> rva.itemImages=rva.itemImages.plus(R.drawable.praia)
                    "Cinema" -> rva.itemImages=rva.itemImages.plus(R.drawable.cinema)
                    "Party" -> rva.itemImages=rva.itemImages.plus(R.drawable.festa)
                    "Sports" -> rva.itemImages=rva.itemImages.plus(R.drawable.desporto1)
                    "Game Night" -> rva.itemImages=rva.itemImages.plus(R.drawable.gamenightlogocolor)
                    "Concert" -> rva.itemImages=rva.itemImages.plus(R.drawable.concerto)
                }
            }
        }
        rva.notifyDataSetChanged()
        requireActivity().findViewById<RecyclerView>(R.id.recyclerView).adapter = rva*/
    }

    override fun onPause() {
        super.onPause()
        requireActivity().findViewById<FloatingActionButton>(R.id.fab).visibility = View.GONE
    }



}