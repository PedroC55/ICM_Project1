package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment



import com.google.android.material.bottomnavigation.BottomNavigationView
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView =  findViewById<BottomNavigationView>(R.id.bottom_navigation)
        if(supportFragmentManager.findFragmentById(R.id.myNavHostFragment)){
            bottomNavigationView.visibility = View.GONE
        }

        //val LoginFragment = LoginFragment()
        val DashboardFragment = DashboardFragment()
        val MapFragment = MapFragment()
        val NearByEventsFragment = NearByEventsFragment()
        val ClassroomScheduleFragment = ClassroomScheduleFragment()


        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> makeCurrentFragment(DashboardFragment)
                R.id.ic_classroom -> makeCurrentFragment(ClassroomScheduleFragment)
                R.id.ic_location -> makeCurrentFragment(MapFragment)
                R.id.ic_social-> makeCurrentFragment(NearByEventsFragment)
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