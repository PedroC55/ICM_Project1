package com.example.myapplication.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.classes.RecyclerViewAdapter
import com.example.myapplication.classes.ScheduleAdapter
import com.example.myapplication.database.DatabaseInfo


class ScheduleFragment : Fragment(R.layout.fragment_schedule) {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_schedule, container, false)
        requireActivity().findViewById<RecyclerView>(R.id.recyclerView2).visibility = View.VISIBLE


        return view
    }

    override fun onPause() {
        super.onPause()
        requireActivity().findViewById<RecyclerView>(R.id.recyclerView2).visibility = View.GONE
    }

}