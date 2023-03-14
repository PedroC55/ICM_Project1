package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import android.widget.ImageButton

import androidx.navigation.findNavController


class DashboardFragment : Fragment(R.layout.fragment_dashboard) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val button: ImageButton = view.findViewById(R.id.profile_button)
        button.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_dashboardFragment_to_profileFragment)}
        return view
    }

}