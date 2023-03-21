package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageButton
import androidx.cardview.widget.CardView

import androidx.navigation.findNavController
import com.example.myapplication.R


class DashboardFragment : Fragment(R.layout.fragment_dashboard) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        requireActivity().findViewById<CardView>(R.id.cardView).visibility = View.GONE
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

}