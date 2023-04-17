package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

import androidx.cardview.widget.CardView
import androidx.core.view.get
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI

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
        val rv : RecyclerView = requireActivity().findViewById(R.id.recyclerView)
        rv.visibility=View.VISIBLE
        val cv = requireActivity().findViewById<CardView>(R.id.cardView)

        val fab : FloatingActionButton = requireActivity().findViewById(R.id.fab)
        fab.visibility = View.VISIBLE
        fab.setOnClickListener{
            findNavController().navigate(R.id.action_dashboardFragment_to_addEventFragment)
        }

        var rva = rv.adapter as RecyclerViewAdapter
        rva.setNav(findNavController())
        rv.adapter=rva

        val db = DatabaseInfo(requireContext(), null)
        val e = db.getEventById(1)
        e.moveToFirst()


        val spinner: Spinner = view.findViewById(R.id.filterTagSpinner)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.tags2,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        val filter : Button = view.findViewById(R.id.buttonFilter)
        filter.setOnClickListener{
            if (spinner.selectedItem.toString()!= "All"){
                var rva1 = rv.adapter as RecyclerViewAdapter
                rva1.hasTag(spinner.selectedItem.toString(), db)
                rv.adapter=rva1
            }
            else{
                var rva2 = rv.adapter as RecyclerViewAdapter
                rva2.hasTag("All", db)
                rv.adapter=rva2
            }
        }


        cv.findViewById<TextView>(R.id.item_title).text = e.getString(1).toString()
        cv.findViewById<TextView>(R.id.item_description).text = e.getString(5).toString()
        when (e.getString(6)){
            "Cinema" -> cv.findViewById<ImageView>(R.id.item_image).setImageResource(R.drawable.cinema)
            "Beach" -> cv.findViewById<ImageView>(R.id.item_image).setImageResource(R.drawable.praia)
            "Party" -> cv.findViewById<ImageView>(R.id.item_image).setImageResource(R.drawable.festa)
            "Sports" -> cv.findViewById<ImageView>(R.id.item_image).setImageResource(R.drawable.desporto1)
            "Game Night" -> cv.findViewById<ImageView>(R.id.item_image).setImageResource(R.drawable.gamenightlogocolor)
            "Concert" -> cv.findViewById<ImageView>(R.id.item_image).setImageResource(R.drawable.concerto)
        }
        return view
    }

    override fun onPause() {
        super.onPause()
        requireActivity().findViewById<FloatingActionButton>(R.id.fab).visibility = View.GONE
        requireActivity().findViewById<RecyclerView>(R.id.recyclerView).visibility=View.GONE
        requireActivity().findViewById<CardView>(R.id.cardView).visibility = View.GONE
        requireActivity().findViewById<CardView>(R.id.cardView2).visibility = View.GONE
        requireActivity().findViewById<Spinner>(R.id.filterTagSpinner).visibility = View.GONE
        requireActivity().findViewById<Button>(R.id.buttonFilter).visibility = View.GONE
    }

}
