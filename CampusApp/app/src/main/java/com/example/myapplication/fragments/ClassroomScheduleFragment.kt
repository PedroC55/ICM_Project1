package com.example.myapplication.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableLayout
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.database.DatabaseInfo


class ClassroomScheduleFragment : Fragment(R.layout.fragment_book_classroom) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_book_classroom, container, false)

        /*val rs = view.findViewById<TableLayout>(R.id.roomSchedule)
        rs.visibility = View.GONE*/

        /*val button = view.findViewById<Button>(R.id.button2)
        button.setOnClickListener{
            rs.visibility = View.VISIBLE
        }*/
        val buttonAnalyse = view.findViewById<Button>(R.id.analyseText)
        buttonAnalyse.setOnClickListener{
            val fragment = requireActivity().supportFragmentManager.findFragmentById(R.id.ll_wrapper)
            var navController = fragment?.findNavController()!!
            navController.navigate(R.id.analyzeTextFragment)
            //findNavController().navigate(R.id.action_classroomScheduleFragment_to_analyzeTextFragment)
        }
        /*val db = DatabaseInfo(requireContext(), null)
        val classroom = db.getClassroomByNumber()
        classroom.moveToFirst()*/
        Log.d("classroom", (this.arguments?.getSerializable("sala")).toString())
        return view
    }



}