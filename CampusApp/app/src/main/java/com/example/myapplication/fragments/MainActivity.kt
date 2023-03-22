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
import com.example.myapplication.R
import com.example.myapplication.classes.Events
import com.example.myapplication.database.DatabaseInfo


import com.google.android.material.bottomnavigation.BottomNavigationView
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView =  findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val context = this
        DatabaseInfo(context, null)
        Toast.makeText(context, "${context.getDatabasePath(DatabaseInfo.DATABASE_NAME)}", Toast.LENGTH_LONG).show()
        Log.d("VeryGood", "${context.getDatabasePath(DatabaseInfo.DATABASE_NAME)}")
        val DashboardFragment = DashboardFragment()
        val MapFragment = MapFragment()
        val NearByEventsFragment = NearByEventsFragment()
        val ClassroomScheduleFragment = ClassroomScheduleFragment()

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> makeCurrentFragment(DashboardFragment)
                R.id.ic_classroom -> makeCurrentFragment(ClassroomScheduleFragment)
                R.id.ic_location -> makeCurrentFragment(MapFragment)
                R.id.ic_social -> makeCurrentFragment(NearByEventsFragment)
            }
            true
        }



    }


    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.ll_wrapper, fragment)
            commit()
        }
}