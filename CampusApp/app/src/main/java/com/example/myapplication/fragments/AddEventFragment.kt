package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.classes.Events
import com.example.myapplication.classes.RecyclerViewAdapter
import com.example.myapplication.database.DatabaseInfo

class AddEventFragment : Fragment(R.layout.fragment_create_event_for_test) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create_event_for_test, container, false)
        requireActivity().findViewById<RecyclerView>(R.id.recyclerView).visibility = View.GONE
        val spinner: Spinner = view.findViewById(R.id.chooseTagSpinner)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.tags,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        val btn : Button = view.findViewById(R.id.addEvent)
        btn.setOnClickListener {
            val db = DatabaseInfo(requireContext(), null)

            // creating variables for values
            // in name and age edit texts
            val a: EditText = view.findViewById(R.id.enterName)
            val name = a.text.toString()
            val b :EditText = view.findViewById(R.id.enterLocation)
            val location = b.text.toString()
            val c : EditText = view.findViewById(R.id.enterHours)
            val hours = c.text.toString()
            val d : EditText = view.findViewById(R.id.enterNP)
            val np = d.text.toString().toInt()
            val tag = spinner.selectedItem.toString()
            val e : EditText = view.findViewById(R.id.enterDescription)
            val description = e.text.toString()
            // calling method to add
            // name to our database
            val ev: Events = Events(name, location, hours, np, description, tag)
            db.insertEventsData(ev)
            view.findNavController().navigate(R.id.action_addEventFragment_to_dashboardFragment)
        }
        return view
    }
}

/*
val btn : Button = findViewById(R.id.addEvent)
btn.setOnClickListener{
    val db = DatabaseInfo(this, null)

    // creating variables for values
    // in name and age edit texts
    val a : EditText = findViewById(R.id.enterName)
    val name = a.text.toString()
    val location = R.id.enterLocation.toString()
    val hours = R.id.enterHours.toString()
    val np = R.id.enterNP
    val tag = R.id.enterTag.toString()
    val description = R.id.enterDescription.toString()
    // calling method to add
    // name to our database
    val e : Events = Events(name, location, hours, np, description, tag)
    db.insertEventsData(e)

    // Toast to message on the screen
    Toast.makeText(this, name + " added to database", Toast.LENGTH_LONG).show()
}*/
