package com.example.myapplication.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.myapplication.R
import com.example.myapplication.database.DatabaseInfo
import com.example.myapplication.classes.RecyclerViewAdapter
import com.example.myapplication.classes.ScheduleAdapter
import com.example.myapplication.classes.StudentScheduleAdapter


import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tomtom.sdk.map.display.internal.db

class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var layoutManager2: RecyclerView.LayoutManager? = null
    private var layoutManager3: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>? = null
    private var adapter2: RecyclerView.Adapter<ScheduleAdapter.ViewHolder>? = null
    private var adapter3: RecyclerView.Adapter<StudentScheduleAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<FloatingActionButton>(R.id.fab).visibility = View.GONE

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, VERTICAL))

        val recyclerView2: RecyclerView = findViewById(R.id.recyclerView2)
        layoutManager2 = LinearLayoutManager(this)
        recyclerView2.layoutManager = layoutManager2
        adapter2 = ScheduleAdapter()
        recyclerView2.adapter = adapter2
        recyclerView2.addItemDecoration(DividerItemDecoration(this, VERTICAL))
        recyclerView2.visibility= View.GONE

        val recyclerView3: RecyclerView = findViewById(R.id.recyclerView3)
        layoutManager3 = LinearLayoutManager(this)
        recyclerView3.layoutManager = layoutManager3
        adapter3 = StudentScheduleAdapter()
        recyclerView3.adapter = adapter3
        recyclerView3.addItemDecoration(DividerItemDecoration(this, VERTICAL))
        recyclerView3.visibility= View.GONE

        val context = this
        val db = DatabaseInfo(context, null)
        val fragment = supportFragmentManager.findFragmentById(R.id.ll_wrapper)
        var navController = fragment?.findNavController()!!

        var rva = recyclerView.adapter as RecyclerViewAdapter
        rva.num = 1
        recyclerView.adapter=rva

        val bottomNavigationView =  findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_home ->navController.navigate(R.id.dashboardFragment)
                R.id.ic_classroom -> navController.navigate(R.id.classroomScheduleFragment)
                R.id.ic_location -> navController.navigate(R.id.pathToClassroomFragment)
                R.id.ic_social -> navController.navigate(R.id.findCampusFragment)
                R.id.ic_profile -> navController.navigate(R.id.profileFragment)
            }
            true
        }
    }

}