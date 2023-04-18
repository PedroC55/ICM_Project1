package com.example.myapplication.fragments

import android.database.Cursor
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.findFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.classes.RecyclerViewAdapter
import com.example.myapplication.classes.StudentScheduleAdapter
import com.example.myapplication.classes.User
import com.example.myapplication.database.DatabaseInfo
import com.google.android.material.bottomnavigation.BottomNavigationView


class ProfileFragment : Fragment(R.layout.fragment_profile) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation).visibility = View.VISIBLE
        val rv : RecyclerView = requireActivity().findViewById(R.id.recyclerView)

        var rva = rv.adapter as RecyclerViewAdapter
        val db = DatabaseInfo(requireContext(), null)
        if(rva.num==2){
            view.findViewById<TextView>(R.id.textView9).visibility=View.GONE
            val i = rva.ts
            val u = db.getUserById(i)
            u.moveToFirst()
            val name = view.findViewById<TextView>(R.id.textView10)
            name.text = u.getString(1)
            val age = view.findViewById<TextView>(R.id.age)
            age.text = getString(R.string.age, u.getString(2))
            val email = view.findViewById<TextView>(R.id.email)
            email.text = getString(R.string.email, u.getString(3))
            val nmec = view.findViewById<TextView>(R.id.nMec)
            nmec.text = getString(R.string.n_mec, u.getString(5))
            val phone = view.findViewById<TextView>(R.id.phoneNumber)
            phone.text = getString(R.string.telem_vel, u.getString(6))
            val nif = view.findViewById<TextView>(R.id.nif)
            nif.text = getString(R.string.nif, u.getString(7))
            val nationality = view.findViewById<TextView>(R.id.nationality)
            nationality.text = getString(R.string.localidade, u.getString(8))
            rva.num = 1
            rv.adapter = rva
        }
        else{
            view.findViewById<TextView>(R.id.textView9).visibility=View.VISIBLE
            val i = rva.getCurrentUser()
            val u = db.getUserById(i)
            val rv3 : RecyclerView = requireActivity().findViewById(R.id.recyclerView3)
            rv3.visibility = View.VISIBLE
            var rva3 = rv3.adapter as StudentScheduleAdapter
            u.moveToFirst()
            rva3.student = u.getString(5).toInt()
            rv3.adapter = rva3

            val name = view.findViewById<TextView>(R.id.textView10)
            name.text = u.getString(1)
            val age = view.findViewById<TextView>(R.id.age)
            age.text = getString(R.string.age, u.getString(2))
            val email = view.findViewById<TextView>(R.id.email)
            email.text = getString(R.string.email, u.getString(3))
            val nmec = view.findViewById<TextView>(R.id.nMec)
            nmec.text = getString(R.string.n_mec, u.getString(5))
            val phone = view.findViewById<TextView>(R.id.phoneNumber)
            phone.text = getString(R.string.telem_vel, u.getString(6))
            val nif = view.findViewById<TextView>(R.id.nif)
            nif.text = getString(R.string.nif, u.getString(7))
            val nationality = view.findViewById<TextView>(R.id.nationality)
            nationality.text = getString(R.string.localidade, u.getString(8))
        }

        return view
    }

    override fun onPause() {
        super.onPause()
        val rv3 : RecyclerView = requireActivity().findViewById(R.id.recyclerView3)
        rv3.visibility = View.GONE
    }

}