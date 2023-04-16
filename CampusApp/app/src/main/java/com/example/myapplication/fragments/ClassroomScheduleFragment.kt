package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableLayout
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.findFragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R


class ClassroomScheduleFragment : Fragment(R.layout.fragment_book_classroom) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_book_classroom, container, false)

        val rs = view.findViewById<TableLayout>(R.id.roomSchedule)
        rs.visibility = View.GONE

        val button = view.findViewById<Button>(R.id.button2)
        button.setOnClickListener{
            rs.visibility = View.VISIBLE
        }

        val buttonAnalyse = view.findViewById<Button>(R.id.analyseText)
        buttonAnalyse.setOnClickListener{
            view.findNavController().navigate(R.id.action_classroomScheduleFragment_to_analyzeTextFragment)
        }

        return view
    }

}