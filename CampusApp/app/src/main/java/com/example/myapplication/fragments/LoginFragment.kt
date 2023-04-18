package com.example.myapplication.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.cardview.widget.CardView

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.classes.RecyclerViewAdapter
import com.example.myapplication.database.DatabaseInfo
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton


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
        val email : EditText = view.findViewById(R.id.editTextTextEmailAddress)
        val pass : EditText = view.findViewById(R.id.editTextTextPassword)
        //view.findViewById<BottomNavigationView>(R.id.bottom_navigation).visibility = View.GONE

        button1.setOnClickListener{
            val db = DatabaseInfo(requireContext(), null)
            val c = db.getUserByEmail(email.text.toString())
            if(c.count <= 0){
                email.error = "Email not found. Please Register!"
            }
            else{
                c.moveToFirst()
                if(pass.text.toString() != c.getString(4)){
                    pass.error = "Invalid password. Try again!"
                }
                else{
                    var rva = requireActivity().findViewById<RecyclerView>(R.id.recyclerView).adapter as RecyclerViewAdapter
                    rva.u = c.getString(0).toInt()
                    requireActivity().findViewById<RecyclerView>(R.id.recyclerView).adapter = rva
                    requireActivity().findViewById<RecyclerView>(R.id.recyclerView).visibility = View.VISIBLE
                    view.findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
                }

            }
        }
        button2.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)}
        return view
    }

    override fun onPause() {
        super.onPause()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation).visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation).visibility=View.GONE
        requireActivity().findViewById<RecyclerView>(R.id.recyclerView).visibility = View.GONE
    }

}