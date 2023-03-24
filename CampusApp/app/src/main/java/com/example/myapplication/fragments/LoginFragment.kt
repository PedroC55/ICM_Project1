package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.navigation.findNavController
import com.example.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView


@Suppress("DEPRECATION")
class LoginFragment : Fragment(R.layout.login) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.login, container, false)
        val button1: Button = view.findViewById(R.id.button_login)
        val button2: Button = view.findViewById(R.id.button_register)
        requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation).visibility = View.GONE
        button1.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)}
        button2.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)}
        return view
    }

    override fun onPause() {
        super.onPause()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation).visibility = View.VISIBLE
    }

}