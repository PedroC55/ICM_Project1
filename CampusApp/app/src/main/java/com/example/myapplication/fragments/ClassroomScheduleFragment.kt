package com.example.myapplication.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.classes.ScheduleAdapter
import com.example.myapplication.database.DatabaseInfo
import org.w3c.dom.Text


class ClassroomScheduleFragment : Fragment(R.layout.fragment_book_classroom) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_book_classroom, container, false)

        /*val rs = view.findViewById<TableLayout>(R.id.roomSchedule)
        rs.visibility = View.GONE*/
        val roomToSearch = view.findViewById<EditText>(R.id.textView8)
        val button = view.findViewById<Button>(R.id.button2)
        button.setOnClickListener{
            var rv = requireActivity().findViewById<RecyclerView>(R.id.recyclerView2)
            var rva = rv.adapter as ScheduleAdapter
            rva.sClassroom(roomToSearch.text.toString())
            val fragment = requireActivity().supportFragmentManager.findFragmentById(R.id.ll_wrapper)
            var navController = fragment?.findNavController()!!
            navController.navigate(R.id.scheduleFragment)
        }
        val buttonAnalyse = view.findViewById<Button>(R.id.analyseText)
        buttonAnalyse.setOnClickListener{
            val fragment = requireActivity().supportFragmentManager.findFragmentById(R.id.ll_wrapper)
            var navController = fragment?.findNavController()!!
            navController.navigate(R.id.analyzeTextFragment)
            //findNavController().navigate(R.id.action_classroomScheduleFragment_to_analyzeTextFragment)
        }
        return view
    }



}