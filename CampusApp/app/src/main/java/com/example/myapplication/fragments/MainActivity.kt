package com.example.myapplication.fragments

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.myapplication.R
import com.example.myapplication.classes.Events
import com.example.myapplication.database.DatabaseInfo
import com.example.myapplication.classes.RecyclerViewAdapter


import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>? = null

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

        val context = this
        DatabaseInfo(context, null)
        val fragment = supportFragmentManager.findFragmentById(R.id.ll_wrapper)
        var navController = fragment?.findNavController()!!

        val bottomNavigationView =  findViewById<BottomNavigationView>(R.id.bottom_navigation)
        /*val DashboardFragment = DashboardFragment()
        val MapFragment = PathToClassroomFragment()
        val NearByEventsFragment = FindCampusFragment()
        val ClassroomScheduleFragment = ClassroomScheduleFragment()*/

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_home ->navController.navigate(R.id.dashboardFragment)
                R.id.ic_classroom -> navController.navigate(R.id.classroomScheduleFragment)
                R.id.ic_location -> navController.navigate(R.id.pathToClassroomFragment)
                R.id.ic_social -> navController.navigate(R.id.findCampusFragment)
            }
            true
        }
    }


    /*private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.ll_wrapper, fragment)
            commit()
        }*/
}